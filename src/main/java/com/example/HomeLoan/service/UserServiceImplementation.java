package com.example.HomeLoan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HomeLoan.model.Users;
import com.example.HomeLoan.repo.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userRepository;

	
	@Override
	public Users createUser(Users user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Optional<Users> getUser(int userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

	@Override
	public String updateUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
