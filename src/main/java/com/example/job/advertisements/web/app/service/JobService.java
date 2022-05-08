package com.example.job.advertisements.web.app.service;

import java.util.List;

import com.example.job.advertisements.web.app.exceptionHandler.JobNotFoundException;
import com.example.job.advertisements.web.app.model.Job;

public interface JobService {
	

	public Job saveJob(Job job);

	public List<Job> getAllJobs();

	public Job getJobById(Long id) throws JobNotFoundException;

	public void deleteJobById(Long id) throws JobNotFoundException;

	public void updateJob(Long id, Job job) throws JobNotFoundException;

}
