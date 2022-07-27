package com.example.HomeLoan.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.HomeLoan.model.SavingAccount;
import com.example.HomeLoan.service.SavingAccountService;

@RestController

public class SavingAccountController {
	@Autowired
	private SavingAccountService service;
	
	
	@PostMapping (value="/SavingAccount/addBalance")
	public SavingAccount createSavingAccount(@RequestBody SavingAccount SavingAccountobj, HttpSession session) {
		return service.saveBalance(SavingAccountobj);
	}
	
	@GetMapping (value="/SavingAccount/UserById/{user}")
	public java.util.List<SavingAccount> findSavingAccountByUserid (@PathVariable int user, HttpSession session) {
	    return service.findAccountByUserId(user);	
	}
	
	
	
	
	
}
