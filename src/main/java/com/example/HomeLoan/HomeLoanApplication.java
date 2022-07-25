package com.example.HomeLoan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HomeLoanApplication {

	public static void main(String[] args) {

		System.out.println("Hello World");
		SpringApplication.run(HomeLoanApplication.class, args);
	}

}
