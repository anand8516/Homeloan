package com.example.HomeLoan.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class utility {
	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	 	 
	private java.sql.Date parseDate(String date) {
	    try {
	        return (java.sql.Date) new Date(DATE_FORMAT.parse(date).getTime());
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}
	 
}
