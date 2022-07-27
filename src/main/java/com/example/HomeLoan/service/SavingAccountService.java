package com.example.HomeLoan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HomeLoan.model.SavingAccount;
import com.example.HomeLoan.model.Users;
import com.example.HomeLoan.repo.SavingAccountRepositiory;

@Service
public class SavingAccountService {

	@Autowired
	private SavingAccountRepositiory SavAccRepo;
	
	public SavingAccount saveBalance(SavingAccount bal) {
		return SavAccRepo.save(bal);	
	}
	
	public List<SavingAccount> findAccountByUserId(int id) {
		return SavAccRepo.findSavingAccountByUser(id);
	}

	

	public SavingAccount findSavingAccountById(Long accountNo, Users users) {
	
		return SavAccRepo.findByAccountnoAndUser(accountNo, users);
	}


	//Count of rows code
	//public SavingAccount getAccountno(int id) {
	//	String count=(String) SavAccRepo.countofSA(userid);
	//	long itr=SavAccRepo.counByRecords(userid);
	//}

}
