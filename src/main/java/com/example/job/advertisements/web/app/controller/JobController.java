package com.example.job.advertisements.web.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@Autowired
	private JobService service;

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

	@GetMapping("/")
	public String showHomePage() {

		return "index";
	}

	@GetMapping("/add")
	public String showAddForm(Job job, Model model) {

		model.addAttribute("locationsList", locationsList);
		model.addAttribute("professionsList", professionsList);
		model.addAttribute("statusList", statusList);
		return "addForm";
	}

	@PostMapping("/add")
	public String saveJob(@ModelAttribute (name="job") @Valid Job job, BindingResult br, Model model) {
		service.saveJob(job);
		Long id = service.saveJob(job).getId();
		model.addAttribute("locationsList", locationsList);
		model.addAttribute("professionsList", professionsList);
		model.addAttribute("statusList", statusList);

		if (br.hasErrors()) {
			return "addForm";
		} 
			
			String message = "Advertisement with id : '" + id + "' is saved successfully !";
			model.addAttribute("message", message);

			return "addForm";
		

	}

	@GetMapping("/getAllJobs")
	public String getAllJobs(@RequestParam(value = "message", required = false) String message, Model model) {
		List<Job> jobs = service.getAllJobs();
		model.addAttribute("list", jobs);
		model.addAttribute("message", message);
		return "listAllJobs";
	}

	@GetMapping("/edit")
	public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam Long id) {
		String page = null;
		try {
			Job job = service.getJobById(id);
			model.addAttribute("job", job);
			page = "editJobPage";
		} catch (JobNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:getAllJobs";
		}
		return page;
	}

	@PostMapping("/update")
	public String updateJob(@ModelAttribute Job job, RedirectAttributes attributes) {
		service.updateJob(job);
		Long id = job.getId();
		attributes.addAttribute("message", "Job advertisement with id: '" + id + "' is updated successfully !");
		return "redirect:getAllJobs";
	}

	@GetMapping("/delete")
	public String deleteJob(@RequestParam Long id, RedirectAttributes attributes) {
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
