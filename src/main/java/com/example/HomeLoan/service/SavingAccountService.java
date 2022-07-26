package com.example.HomeLoan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HomeLoan.model.SavingAccount;
import com.example.HomeLoan.model.Users;
import com.example.HomeLoan.repo.SavingAccountRepositiory;

@Service
public class SavingAccountService {

	@Autowired
	private SavingAccountRepositiory SavAccRepo;
	
	public SavingAccount saveBalance(SavingAccount balance) {
		return SavAccRepo.save(balance);	
	}
	
	//public SavingAccount getProductbyuser (Users user) {
	//	return SavAccRepo.findbyUser(user);	
	//}
	
	
}
