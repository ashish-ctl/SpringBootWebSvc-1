package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class UserService {

	public static List<User> userList = new ArrayList<User>();
	static {
		userList.add(new User(1, "user1", "SoftwareDevEngineer-1", "Bengaluru", "KA", "India"));
		userList.add(new User(2, "user2", "SoftwareDevEngineer-2", "Noida", "UP", "India"));
		userList.add(new User(3, "user3", "SoftwareQAEngineer-1", "Bengaluru", "KA", "India"));
		userList.add(new User(4, "user4", "SoftwareQAEngineer-2", "Noida", "UP", "India"));
		userList.add(new User(5, "user5", "SoftwareQAEngineer-2", "Bengaluru", "KA", "India"));
		userList.add(new User(6, "user6", "SoftwareDevConsultant-1", "Bengaluru", "KA", "India"));
		userList.add(new User(7, "user7", "SoftwareDevConsultant-1", "Bengaluru", "KA", "India"));
		userList.add(new User(8, "user8", "SoftwareDevConsultant-2", "Bengaluru", "KA", "India"));
		userList.add(new User(9, "user9", "SoftwareQAConsultant-1", "Noida", "UP", "India"));
		userList.add(new User(10, "user10", "SoftwareDevManager-1", "Bengaluru", "KA", "India"));
	}

	public List<User> getAllUsers() {
		return userList;
	}

	public User getUserById(int id) {
		/*User user = null;
		for (User u : userList) {
			if (u.getUserId() == id)
				user = u;
		}
		return user;*/
		
		User user = userList.stream().filter(p-> id == p.getUserId()).findAny().orElse(null);
		return user;
	}
	
	public User getUserByName(String name) {
		User user = userList.stream().filter(p-> name.equals(p.getUserName())).findAny().orElse(null);
		return user;
	}
	
	public List<User> getUserByRole(String role) {
		return  userList.stream().filter(p -> role.equals(p.getUserRole())).collect(Collectors.toList());
	}

}
