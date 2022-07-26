package com.example.HomeLoan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.HomeLoan.service.PaymentService", "com.beta.ruleService"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HomeLoanApplication {


	private static final Logger logger = LogManager.getLogger(HomeLoanApplication.class);
	public static void main(String[] args) {

	       logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");
		SpringApplication.run(HomeLoanApplication.class, args);
	}

}
