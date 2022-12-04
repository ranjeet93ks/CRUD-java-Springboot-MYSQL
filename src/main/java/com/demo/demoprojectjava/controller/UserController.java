package com.demo.demoprojectjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.demoprojectjava.entity.UserEntity;
import com.demo.demoprojectjava.repository.UserRepository;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email) {
		UserEntity user = new UserEntity();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		userRepository.save(user);
		return "User Created";
	}

	@GetMapping(path = "/getAll")
	public @ResponseBody List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/getUserByEmail")
	public @ResponseBody UserEntity getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}