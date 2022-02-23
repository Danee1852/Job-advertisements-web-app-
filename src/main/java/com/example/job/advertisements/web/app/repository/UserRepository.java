package com.example.job.advertisements.web.app.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.job.advertisements.web.app.model.User;

public interface UserRepository extends CrudRepository <Long ,User> {

	User save (User user);

	User findById (long id);

	void deleteById(Long id);

}
