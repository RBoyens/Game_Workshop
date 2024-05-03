package com.ryan.gameWorkshopJava.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.gameWorkshopJava.models.User;
import com.ryan.gameWorkshopJava.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
// Create
	
	public User createUser(User user) {
		return userRepository.save(user);
	}

// Read
	
	public ArrayList<User> all(){
		return userRepository.findAll();
	}
	public User findOne(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
		
// Update
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
		
// Delete
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
