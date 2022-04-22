package com.example.job.advertisements.web.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.job.advertisements.web.app.model.User;

public interface UserRepository extends CrudRepository<User,Long> {
	
	Optional<User> findByNameAndPassword(String name, String password);
	public Long countById(Long id);
}