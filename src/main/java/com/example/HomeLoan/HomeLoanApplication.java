package com.example.HomeLoan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.example.HomeLoan.model.Repayment;
import com.example.HomeLoan.service.LoanRepaymentService;
import com.example.HomeLoan.service.utility;

import antlr.collections.List;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HomeLoanApplication {
	
	
	private static final Logger logger = LogManager.getLogger(HomeLoanApplication.class);
	public static void main(String[] args) {
		
		
		LoanRepaymentService obj = new LoanRepaymentService();
		utility dj = new utility();
		obj.generateRepaymentSchedule(dj.parseDate("2022-07-26"),5000000, 7, 10, 0);
		
        logger.info("Info log");
		SpringApplication.run(HomeLoanApplication.class, args);
		
		
	}
}
