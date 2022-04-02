package com.example.job.advertisements.web.app;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.job.advertisements.web.app.model.User;
import com.example.job.advertisements.web.app.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void testAddNewUser() {
		
		User user = new User();
		
		user.setName("Danee");
		user.setEmail("danee123@gmail.com");
		user.setPassword("qwerty1234");
		user.setQualification("Java Developer");
		user.setRole("user");
		
		User savedUser = repository.save(user);
		
		Assertions.assertThat(savedUser).isNotNull();
		Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
		
		
	}
	@Test
	public void testDeleteUser() {
		
		long userId=10;
		
		Optional<User> optionalUser= repository.findById(userId);
		
		Assertions.assertThat(optionalUser).isNotPresent();
		
	}
}
