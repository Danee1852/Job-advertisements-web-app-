
package com.example.job.advertisements.web.app.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.job.advertisements.web.app.model.Job;

public interface JobRepository extends JpaRepository <Job, Long> {

	
	@Query("SELECT j FROM Job j WHERE CONCAT(j.title, ' ', j.description, ' ', j.profession, ' ', j.location) LIKE %?1%")
	public Page<Job> findJobByKeyword(String keyword, Pageable pageable);
	

}
