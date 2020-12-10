package com.example.demo.rest;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exception.InvalidUserNameException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserDbService;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	/*@Autowired
	UserService userService;*/
	
	@Autowired
	UserDbService userService;

	@GetMapping("/users")
	@ApiOperation(value="Get All Users" , notes=" Use this Api to get Details of All the Users in Database." , response=List.class)
	public List<User> getAllUsers() {
		logger.info("getAllUsers()..");
		return userService.getAllUsers();
	}

	@GetMapping("/user/{id}")
	@ApiOperation(value="Get User By Id" , notes=" Use this Api to get Details of Single Users from Database for a Specific Id ", response = User.class)
	public User getUserById(@PathVariable int id) {
		logger.info("getUserById() ..");
		User user = userService.getUserById(id);
		if (user == null)
			throw new UserNotFoundException("User not found In database");
		else
			return user;
	}

	@GetMapping("/user/name/{name}")
	public User getUserByName(@PathVariable String name) {
		logger.info("getUserByName() ..");
		User user = userService.getUserByName(name);
		if (user == null)
			throw new UserNotFoundException("User not found In database");
		else if(user!=null && user.getUserName().equalsIgnoreCase("user1"))
			throw new InvalidUserNameException("User Name Serch Forbidden.");
		else
			return user;
	}

	@GetMapping("/user/role/{role}")
	public List<User> getUserByRole(@PathVariable String role) {
		logger.info("getUserByRole() ..");
		return userService.getUserByRole(role);
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> createNewUser(@RequestBody User user) {
		logger.info("createNewUser() ..");
		userService.createNewUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/user/{id}")
	public List<User> deleteUser(@PathVariable int id){
		logger.info("deleteUser() ..");
		return userService.deleteUser(id);
	}
	
}
