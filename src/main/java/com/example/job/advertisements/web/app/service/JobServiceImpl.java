package com.example.job.advertisements.web.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.job.advertisements.web.app.exceptionHandler.JobNotFoundException;
import com.example.job.advertisements.web.app.model.Job;
import com.example.job.advertisements.web.app.repository.JobRepository;

public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository repository;

	@Override
	public Job saveJob(Job job) {

		return repository.save(job);
	}

	@Override
	public List<Job> getAllJobs() {

		return repository.findAll();
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
	public void updateJob(Job job) {

		repository.save(job);
	}

}
