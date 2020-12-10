package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String name);
	public List<User> findByUserRole(String role);
	
}
