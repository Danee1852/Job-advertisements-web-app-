
package com.example.job.advertisements.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.job.advertisements.web.app.model.Job;

public interface JobRepository extends JpaRepository <Job, Long> {

	public List<Job> findByTitleContaining(String title);

}
