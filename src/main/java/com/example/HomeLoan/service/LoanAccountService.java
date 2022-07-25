package com.example.HomeLoan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.repo.LoanAccountRepository;

public class LoanAccountService {
	
	@Autowired
	private LoanAccountRepository repo;
	
	
	public LoanAccount saveAppliedLoan( LoanAccount obj) {

		return repo.save(obj);
	}
	
	public List<LoanAccount> getLoanDetails(Integer id) {

		return repo.findByLoanAccId(id);
	}
}
