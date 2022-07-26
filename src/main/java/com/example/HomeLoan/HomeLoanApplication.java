package com.example.HomeLoan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HomeLoanApplication {
	
	
	private static final Logger logger = LogManager.getLogger(HomeLoanApplication.class);
	public static void main(String[] args) {
		
		
		
		
		
        logger.info("Info log");
		SpringApplication.run(HomeLoanApplication.class, args);

		
	}
}
