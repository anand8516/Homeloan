package com.example.HomeLoan.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.HomeLoan.HomeLoanApplication;
import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.service.LoanAccountService;


@RestController
public class LoanController {
	
	private static final Logger logger = LogManager.getLogger(LoanController.class);
	
	@Autowired
	private LoanAccountService loanAccService;



	@RequestMapping(value = {"/applyLoan","/approveLoan"}, method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Object> applyForLoan(@RequestBody LoanAccount loanAcc,HttpSession session) {
		logger.info("createLoanAccount applyForLoan> "+loanAcc);
		Map<String, Object> body = new LinkedHashMap<>();
		double salary  = loanAcc.getSalary();
		double loanAmt  = loanAcc.getAmount();
		
		 //check eligible
		if(loanAccService.isLoanEligible(salary,loanAmt)) {
			LoanAccount acc = loanAccService.createLoanAccount(loanAcc,1);
			body.put("status","Congrats");
			body.put("Loan Acc", acc);
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		else {
			double eligibleAmt = loanAccService.calculateEligibleLoanAmt(salary);
			loanAcc.setAmount(eligibleAmt);
			body.put("status","Pending");
			body.put("Loan Acc", loanAcc);
			return new ResponseEntity<>(body, HttpStatus.OK);
			
		}		
		
	}



}
