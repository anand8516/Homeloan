package com.example.HomeLoan.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class utility {
//	private static final Logger logger = LogManager.getLogger(utility.class);
	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	 	 
	public Date parseDate(String date) {
	    try {
	        return new Date(DATE_FORMAT.parse(date).getTime());
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}
	
	public String formatDate(Date date) {
		return DATE_FORMAT.format(date);	
	}
	
	public Date addMonths(Date date,int months) {		
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		String s = DATE_FORMAT.format(date);	
		LocalDate localdate = LocalDate.parse(s);
		LocalDate newDate = localdate.plusMonths(months); 		
		System.out.println("New Date : "+newDate);
		Date date_new = Date.from(newDate.atStartOfDay(ZoneId.systemDefault()).toInstant());		
		return date_new;	    
	}
	 
}
