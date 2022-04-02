package com.example.job.advertisements.web.app.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job.advertisements.web.app.DTO.UserRegistrationDto;
import com.example.job.advertisements.web.app.exceptionHandler.UserNotFoundException;
import com.example.job.advertisements.web.app.model.User;
import com.example.job.advertisements.web.app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User create(UserRegistrationDto registrationDto) {

		User user = new User(registrationDto.getName(),
				registrationDto.getEmail(),
				registrationDto.getPassword());
		return repository.save(user);
	}

	public User update(User user, long id) throws UserNotFoundException {

		Optional<User> result = repository.findById(id);

		if (result.isPresent()) {
			return result.get();
		}
		throw new UserNotFoundException("Could not find any user with ID: " + id);

	
	}

	public void delete(Long id) throws UserNotFoundException {
		
		Long count = repository.countById(id);
		if(count == null || count ==0) {
			throw new UserNotFoundException("Could not find any user with ID: "+id);
		}
		
		repository.deleteById(id);
	}

	public void save(User user) {
		repository.save(user);

	}

	// Need to add login method

}
