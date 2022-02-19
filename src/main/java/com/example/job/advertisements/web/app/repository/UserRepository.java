package com.example.job.advertisements.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job.advertisements.web.app.model.User;

public interface UserRepository extends JpaRepository <Long ,User> {

}
