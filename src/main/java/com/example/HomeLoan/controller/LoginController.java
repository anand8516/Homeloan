package com.example.HomeLoan.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HomeLoan.model.AuthenticationDetails;
import com.example.HomeLoan.model.Users;
import com.example.HomeLoan.service.UserService;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
	@Autowired	
	UserService userService;
	
	@PostMapping(value="/Users")
	public Users createUser(@Valid @RequestBody Users user) {
		
		return userService.createUser(user);
	}
		
	
	@GetMapping(value = "api/getuser/{userId}")
	public Optional<Users> getUser(@Valid @PathVariable int userId) {
		
		return userService.getUser(userId);
	}
	
	@PostMapping(value = "/login")
	public String loginUser(@RequestBody AuthenticationDetails authenticationDetails, HttpSession session){
		return userService.login(authenticationDetails, session);
	}
	
	@GetMapping(value = "/login")
	public String loginUser(){
		return "Welcome to Barclays Bank";
	}
	
	
	@PutMapping(value="/Users/{userId}")
	public void updateUser(@Valid @RequestBody Users user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping(value = "Delete/{userId}")
	public String deleteUser(@Valid @PathVariable Integer userId)
	
	{
		
		userService.deleteUser(userId);
		return "deleted";
	}
	@GetMapping(value = "/allUser")
	public List<Users> getAllUser() {
		return userService.getAllUser();
	}
	{
		
	}


}
