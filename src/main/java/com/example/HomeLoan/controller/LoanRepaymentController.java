
package com.example.HomeLoan.controller;

import java.util.*;

import com.example.HomeLoan.service.LoanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.service.LoanRepaymentService;

@RestController
public class LoanRepaymentController {
	@Autowired
	private LoanRepaymentService loanservice;

	@Autowired
	private LoanAccountService loanAccountService;
	
	
	@GetMapping("/loanscheduler/{id}/")
	public LoanAccount findLoandetaisbyID(@PathVariable int Id) {
		return loanservice.getLoanAccountById(Id);
	}

	@PostMapping("/prepayment/{loanaccountno}")
	public ResponseEntity<? >  updateEMIDetails(@PathVariable int loanaccountno,@RequestBody Double partialPaymentAmount) {


		try {

			return new ResponseEntity<>( loanservice.updateEMIDetails(loanaccountno,partialPaymentAmount), HttpStatus.OK);
		}
		catch(Exception e){

			return new ResponseEntity<>("Error occurred during prepayment", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/emipayment/{loanaccountno}")
	public ResponseEntity<?> updateMonthlyEMIPayment(@PathVariable int loanaccountno)
	{
		try {

			return new ResponseEntity<>( loanservice.emiPayment(loanaccountno), HttpStatus.OK);
		}
		catch(Exception e){

			return new ResponseEntity<>("Error occurred during prepayment", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
