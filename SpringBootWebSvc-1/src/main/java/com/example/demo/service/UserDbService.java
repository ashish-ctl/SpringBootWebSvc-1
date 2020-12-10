package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@Service
public class UserDbService {
	Logger logger = LoggerFactory.getLogger(UserDbService.class);

	@Autowired
	UserRepository userRepo;

	public List<User> getAllUsers() {
		logger.info("getAllUsers() in UserDbService");
		return userRepo.findAll();
	}

	public User getUserById(int id) {
		logger.info("getUserById() in UserDbService");
		User user = userRepo.findAll().stream().filter(p -> id == p.getUserId()).findAny().orElse(null);
		return user;
	}

	public User getUserByName(String name) {
		logger.info("getUserByName() in UserDbService");
		return userRepo.findByUserName(name);
	}

	public List<User> getUserByRole(String role) {
		logger.info("getUserByRole() in UserDbService");
		return userRepo.findByUserRole(role);
	}
	
	@Cacheable(value="usercache", key="#name")
	public User getUserByNameCachedEnabled(String name) {
		logger.info("getUserByName() in UserDbService");
		return userRepo.findByUserName(name);
	}

	public void createNewUser(User user) {
		logger.info("createNewUser() in UserDbService");
		userRepo.save(user);
	}

	public List<User> deleteUser(int id) {
		logger.info("deleteUser() in UserDbService");
		for(User u : userRepo.findAll()) {
			if(u.getUserId()==id) {
				userRepo.delete(u);
			}
		}
		return userRepo.findAll();
		
	}
	
	

}
