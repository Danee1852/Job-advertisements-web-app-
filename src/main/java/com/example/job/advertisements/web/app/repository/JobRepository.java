package com.example.job.advertisements.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job.advertisements.web.app.model.Job;

public interface JobRepository extends JpaRepository <Long, Job>{
	
	List<Job> findByTitleContaining (String title);

}
