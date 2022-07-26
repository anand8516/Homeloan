package com.example.HomeLoan.service;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.HomeLoan.controller.LoanController;
import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.model.SavingAccount;
import com.example.HomeLoan.repo.LoanAccountRepository;
import com.example.HomeLoan.repo.SavingAccountRepositiory;
@Service
public class LoanAccountService {
	
	
	private static final Logger logger = LogManager.getLogger(LoanAccountService.class);
	
	@Autowired
	private LoanAccountRepository loanAccrepo;
	

	
	@Autowired
	private SavingAccountRepositiory savingAccRepo;
	
		
	@Autowired
	private SavingAccountService savingAccountService;
	
	public LoanAccount saveAppliedLoan( LoanAccount obj) {

		return loanAccrepo.save(obj);
	}
	
	public LoanAccount getLoanDetails(Integer id) {

		return loanAccrepo.findByLoanAccId(id);
	}
	

	public  double calculateEligibleLoanAmt(double salary) {
		return salary * 50;
	}

	public boolean isLoanEligible(double salary, double loanAmt) {
		return salary * 50 >= loanAmt;
	}

	public LoanAccount createLoanAccount(LoanAccount loanAcc, int user_id) {
		SavingAccount userAccount = savingAccRepo.findByAccountno(loanAcc.getAccountNo());
		logger.info("createLoanAccount service> "+loanAcc.getAccountNo());
		loanAcc.setAccountNo(userAccount.getAccountno());
		loanAcc.setStatus("Approved");
		return loanAccrepo.save(loanAcc);
		
	}


	
}
