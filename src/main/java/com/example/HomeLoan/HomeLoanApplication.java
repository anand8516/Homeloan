package com.example.HomeLoan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.example.HomeLoan.service.LoanRepaymentService;
import com.example.HomeLoan.service.RepaymentService;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HomeLoanApplication {
	
	
	private static final Logger logger = LogManager.getLogger(HomeLoanApplication.class);
	public static void main(String[] args) {
							
        logger.info("Info log InSIde Home APP");
		SpringApplication.run(HomeLoanApplication.class, args);
//		updateRepayment
//		LoanRepaymentService obj =  new LoanRepaymentService();
//		obj.generateRepaymentSchedule(new Date(),5000000, 7,20,0);

		LoanRepaymentService obj1 =  new LoanRepaymentService();
		obj1.updateRepayment(1);

	}
}
