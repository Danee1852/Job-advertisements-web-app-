package com.example.job.advertisements.web.app;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.job.advertisements.web.app.model.Job;
import com.example.job.advertisements.web.app.service.JobService;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@SpringBootTest
public class JobTests {
	
	private final JobService jobService;

	
	@Autowired
    public JobTests(JobService jobService) {
		
		this.jobService = jobService;
	}



	/*
	 * @Test void addjobShouldReturnJobInstance() { //given Job job = new Job();
	 * job.setTitle("Title"); job.setDescription("Description"); //when Job savedJob
	 * = jobService.saveJob(job); //then assertAll( () -> assertNotNull(savedJob),
	 * () -> assertInstanceOf(Job.class, savedJob) ); }
	 * 
	 * @Test void addJobShouldAutoIncrementId() { //given Job job = new Job();
	 * job.setTitle("Title"); job.setDescription("Description"); //when Job savedJob
	 * = jobService.saveJob(job); //then assertNotNull(savedJob.getId()); }
	 */


}
