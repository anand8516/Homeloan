
package com.example.HomeLoan.controller;

import java.util.*;
public class LoanRepaymentController {
	public void RepaymentSchedule (double principleAmount, double interestRate,double tenure) {
	System.out.println("Hello World");
	double p = principleAmount;
	double r = interestRate/12;
	double t = tenure * 12;
	double emi = (p*r*Math.pow(1+r,t))/(Math.pow(1+r,t)-1);
	double balance = p;
	
	List<ArrayList<Double>> listOfLists = new ArrayList<ArrayList<Double>> ();
	for(int i=0;i<t;i++){
		double mInterest = balance * r;
		double paidPrinciple = emi - mInterest;
		balance = balance - paidPrinciple;
		
		ArrayList<Double> temp = new ArrayList<>();
		temp.add(mInterest);
		temp.add(paidPrinciple);
		temp.add(balance);
		listOfLists.add(temp);
		}
	}
	
}
