package com.example.job.advertisements.web.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.job.advertisements.web.app.model.User;

public interface UserRepository extends CrudRepository<User,Long> {
	
	public Long countById(Long id);
}