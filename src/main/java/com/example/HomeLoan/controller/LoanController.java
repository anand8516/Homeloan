package com.example.HomeLoan.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.HomeLoan.HomeLoanApplication;
import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.model.Repayment;
import com.example.HomeLoan.model.SavingAccount;
import com.example.HomeLoan.model.Users;
//import com.homeloan.app.service.EmailService;
import com.example.HomeLoan.service.LoanAccountService;
import com.example.HomeLoan.service.RepaymentService;
import com.example.HomeLoan.service.SavingAccountService;
import com.example.HomeLoan.service.UserService;

@RestController
public class LoanController {
	
	private static final Logger logger = LogManager.getLogger(LoanController.class);
	
	
	@RequestMapping(value = "/applyLoan", method = RequestMethod.POST, consumes = "multipart/form-data", produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public String applyForLoan(LoanAccount loanAcc, HttpSession session, @RequestParam("docs") MultipartFile file) {
//	    String user_id = (String) session.getAttribute("user_id");
//		if(user_id == null || user_id.equals("")) {
//			return "redirect:/login";
//		}

		logger.info("LoanController > applyForLoan");
		return "redirect:/";
	}
	
}
