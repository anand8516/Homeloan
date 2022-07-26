
package com.example.HomeLoan.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.model.Repayment;
import com.example.HomeLoan.service.LoanRepaymentService;

@RestController
public class LoanRepaymentController {
	
	@Autowired
	private LoanRepaymentService loanservice;
	
//	public ResponseEntity<Object> applyForLoan(@RequestBody LoanAccount loanAcc,HttpSession session) {}
	
	@GetMapping(value = "/loanscheduler")
	public List<LoanAccount> findLoandetais(HttpSession session) {
		return loanservice.getLoanAccounts();
	}
	
//	@PostMapping(value = "/loanscheduler/{id}/")
//	public List<Repayment> findLoanSchedulebyID(@PathVariable Long id) {
//		return loanservice.getLoanSchedulebyID(id);
//	}
	
	@PostMapping(value = "/loanndetails/{id}/")
	public LoanAccount findLoandetaisbyID(@PathVariable int id,HttpSession session) {
		return loanservice.getLoanAccountById(id);
	}
	
}
