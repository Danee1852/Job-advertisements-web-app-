package com.example.job.advertisements.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job.advertisements.web.app.model.User;
import com.example.job.advertisements.web.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public User create(User user) {
	
		
		return repository.save(user);
	}
	
	public User update(User user, long id) {
		
		User currentUser = repository.findById(id);
		
		user.setName(currentUser.getName());
		user.setEmail(currentUser.getEmail());
		user.setPassword(currentUser.getPassword());
		user.setQualification(currentUser.getQualification());
		user.setRole(currentUser.getRole());
		
		return repository.save(currentUser);
		
	}
	
	public void delete (Long id) {
	
		repository.deleteById(id);
	}
	
	// Need to add login method

}
