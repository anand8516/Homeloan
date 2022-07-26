
package com.example.HomeLoan.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.service.LoanRepaymentService;
public class LoanRepaymentController {
	private LoanRepaymentService loanservice;
	
	
	@GetMapping("/loanscheduler/{id}/")
	public LoanAccount findLoandetaisbyID(@PathVariable int Id) {
		return loanservice.getLoanAccountById(Id);
	}
	
}
