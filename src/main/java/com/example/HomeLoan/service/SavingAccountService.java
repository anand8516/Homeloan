package com.example.HomeLoan.service;

import java.util.List;
import java.util.Optional;


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
	public List<SavingAccount> getAccDetails(Integer user_id) {

		return SavAccRepo.findSavingAccByUserid(user_id);
	}
	

	

	public SavingAccount findSavingAccountById(Long accountNo, Users users) {
	
		return SavAccRepo.findByAccountnoAndUser(accountNo, users);
	}


>>>>>>> 99a4d62c95ad322c30edd4be034c65000044e42d
	//Count of rows code
	//public SavingAccount getAccountno(int id) {
	//	String count=(String) SavAccRepo.countofSA(userid);
	//	long itr=SavAccRepo.counByRecords(userid);
	//}

}
