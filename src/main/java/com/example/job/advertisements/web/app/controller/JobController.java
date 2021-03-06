package com.example.job.advertisements.web.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.job.advertisements.web.app.exceptionHandler.JobNotFoundException;
import com.example.job.advertisements.web.app.model.Job;
import com.example.job.advertisements.web.app.service.JobService;

@Controller
@RequestMapping("/job")
public class JobController {

	public static final Logger LOGGER = Logger.getLogger(JobController.class.getName());

	private JobService service;

	public JobController(JobService service) {
		LOGGER.info("JobController( " + service + ")");
		this.service = service;
	}

	static List<String> locationsList = null;

	static {
		locationsList = new ArrayList<>();
		locationsList.add("Warsaw");
		locationsList.add("Poznan");
		locationsList.add("Wroclaw");
		locationsList.add("Krakow");

	}

	static List<String> professionsList = null;

	static {
		professionsList = new ArrayList<>();
		professionsList.add("Java Developer");
		professionsList.add("JS Develper");
		professionsList.add("Python Developer");
		professionsList.add("Kotlin Developer");
		professionsList.add("GO Developer");
		professionsList.add("Manual Tester");
		professionsList.add("Consultant");

	}

	static List<String> statusList = null;

	static {
		statusList = new ArrayList<>();
		statusList.add("Enabled");
		statusList.add("Disabled");

	}

	private void initModel(Model model) {
		model.addAttribute("locationsList", locationsList);
		model.addAttribute("professionsList", professionsList);
		model.addAttribute("statusList", statusList);
	}

	@GetMapping("/")
	public String showHomePage() {

		return "index";
	}

	@GetMapping("/add")
	public String showAddForm(Job job, Model model) {

		initModel(model);
		return "addForm";
	}

	@PostMapping("/add")
	public String saveJob(@ModelAttribute(name = "job") @Valid Job job, BindingResult br, Model model) {

		LOGGER.info("PostMapping saveJob(" + job + ")");

		initModel(model);
		if (br.hasErrors()) {
			return "addForm";
		}
		Long id = service.saveJob(job).getId();
		String message = "Advertisement with id : '" + id + "' is saved successfully !";
		model.addAttribute("message", message);
		service.saveJob(job);

		return "addForm";

	}

	/*
	 * @GetMapping("/getAllJobs") public String getAllJobs(@RequestParam(value =
	 * "message", required = false) String message, Model model) {
	 * 
	 * List<Job> jobs = service.getAllJobs(); model.addAttribute("list", jobs);
	 * model.addAttribute("message", message); return "listAllJobs"; }
	 */

	@GetMapping("/getAllJobs")
	public String getAllPages(Model model) {

		return getOnePage(model, 1);
	}

	@GetMapping("/getAllJobs/page/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<Job> page = service.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Job> jobs = page.getContent();

		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("list", jobs);

		return "listAllJobs";
	}

	@GetMapping("/getAllJobs/page/{pageNumber}/{field}")
	public String getPageWithSort(Model model, @PathVariable("pageNumber") int currentPage, @PathVariable String field,
			@PathParam("sortDir") String sortDir, @Param("keyword") String keyword) {

		Page<Job> page = service.findJobsWithSort(field, sortDir, currentPage, keyword);
		List<Job> jobs = page.getContent();
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();

		model.addAttribute("keyword", keyword);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);

		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("list", jobs);

		model.addAttribute("field", field);
		return "listAllJobs";

	}

	@GetMapping("/edit")
	public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam Long id) {

		String page = null;
		initModel(model);
		try {

			Job job = service.getJobById(id);
			model.addAttribute("job", job);
			page = "editJobPage";

		} catch (JobNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "getAllJobs";
		}
		return page;
	}

	@PostMapping("/edit/{id}")
	public String updateJob(@PathVariable Long id, @ModelAttribute(name = "job") Job job, Model model,
			RedirectAttributes attributes) {

		LOGGER.info("PostMapping updateJob(" + job + ", " + id + ")");

		initModel(model);

		try {

			service.updateJob(id, job);
			attributes.addAttribute("message", "Job advertisement with id: " + id + " is updated successfully !");
			return "redirect:/job/getAllJobs";
		} catch (JobNotFoundException e) {

			e.printStackTrace();
			return "redirect:getAllJobs";
		}

	}

	@GetMapping("/delete")
	public String deleteJob(@RequestParam Long id, RedirectAttributes attributes) {

		LOGGER.info("GetMapping deleteJob(" + id + ")");

		try {
			service.deleteJobById(id);
			attributes.addAttribute("message", "Job with Id : '" + id + "' is removed successfully!");
		} catch (JobNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:getAllJobs";
	}
}
