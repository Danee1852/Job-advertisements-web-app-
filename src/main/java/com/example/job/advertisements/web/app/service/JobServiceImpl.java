package com.example.job.advertisements.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.job.advertisements.web.app.exceptionHandler.JobNotFoundException;
import com.example.job.advertisements.web.app.model.Job;
import com.example.job.advertisements.web.app.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository repository;

	@Override
	public Job saveJob(Job job) {

		return repository.save(job);
	}

	
	  @Override public List<Job> getAllJobs() {
	  
	  return repository.findAll(); }
	 
	
	public Page<Job> findPage(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 5);
		
		return repository.findAll(pageable);
				
	}
	
	public Page<Job> findJobsWithSort(String field, String direction, int pageNumber) {
		Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(field).ascending(): Sort.by(field).descending();
		Pageable pageable = PageRequest.of(pageNumber - 1, 5,sort);

		return repository.findAll(pageable);
	}
	
	

	@Override
	public Job getJobById(Long id) throws JobNotFoundException {

		Optional<Job> optional = repository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new JobNotFoundException("Job with id: " + id + " not found ");
		}

	}

	@Override
	public void deleteJobById(Long id) throws JobNotFoundException {
		repository.delete(getJobById(id));

	}

	@Override
	public void updateJob(Long id, Job job) throws JobNotFoundException {

		Job dbJob = getJobById(id);

		if (dbJob != null) {

			dbJob.setStatus(job.getStatus());
			dbJob.setTitle(job.getTitle());
			dbJob.setLocation(job.getLocation());
			dbJob.setDescription(job.getDescription());
			dbJob.setProfession(job.getProfession());

			repository.save(dbJob);
		} else {
			repository.save(job);
		}

	}


}
