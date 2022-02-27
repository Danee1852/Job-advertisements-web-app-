package com.example.job.advertisements.web.app.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job.advertisements.web.app.exceptionHandler.UserNotFoundException;
import com.example.job.advertisements.web.app.model.User;
import com.example.job.advertisements.web.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public User create(User user) {
	
		
		return repository.save(user);
	}
	
	public User update(User user, long id) throws UserNotFoundException {
		
		Optional<User> result= repository.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
		throw new UserNotFoundException("Could not find any user with ID: "+id);
		
		/*
		 * User currentUser = repository.findById(id);
		 * 
		 * user.setName(currentUser.getName()); user.setEmail(currentUser.getEmail());
		 * user.setPassword(currentUser.getPassword());
		 * user.setQualification(currentUser.getQualification());
		 * user.setRole(currentUser.getRole());
		 * 
		 * return repository.save(currentUser);
		 */
	}
	
	public void delete (Long id) {
	
		repository.deleteById(id);
	}

	// new function
	public void save(User user) {
		repository.save(user);
		
	}
	
	// Need to add login method

}
