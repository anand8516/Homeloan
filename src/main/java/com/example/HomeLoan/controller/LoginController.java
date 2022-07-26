package com.example.HomeLoan.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HomeLoan.model.Users;
import com.example.HomeLoan.service.UserService;



@RestController
public class LoginController {
	@Autowired	
	UserService userService;
	
	@PostMapping(value="/Users")
	public Users createUser(@RequestBody Users user) {
		
		return userService.createUser(user);
	}
		
	
	@GetMapping(value = "api/getuser/{userId}")
	public Optional<Users> getUser(@PathVariable int userId) {
		
		return userService.getUser(userId);
	}
	
	@PutMapping(value="/Users/{userId}")
	public void updateUser(@RequestBody Users user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping(value = "Delete/{userId}")
	public String deleteUser(@PathVariable Integer userId)
	
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
