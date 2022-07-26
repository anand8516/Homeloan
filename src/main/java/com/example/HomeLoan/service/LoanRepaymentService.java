package com.example.HomeLoan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.model.Repayment;

@Service
public class LoanRepaymentService {
	
	@Autowired
	private LoanAccount repo;
	List<Repayment> repaySchedule;	
	public void getLoanAccountById(int LoanId) {
//		return LoanAccount.findByLoanAccId(LoanId);		
	}
	
	
	
	public double calInterest(double outstanding,double mothlyRateOfInterest) {		
		return outstanding * mothlyRateOfInterest;
	}
	
	public double calPaidPrinciple(double emi,double mInterest) {		
		return emi - mInterest;
	}
	
	public double calMonthlyEmi(double principle,double mothlyRateOfInterest,double tenureInMonths) {						
		return (principle*mothlyRateOfInterest*Math.pow(1+mothlyRateOfInterest,tenureInMonths))/(Math.pow(1+mothlyRateOfInterest,tenureInMonths)-1);
	}
	
	@SuppressWarnings("null")
	public void generateRepaymentSchedule(double principleAmount, double interestRate,double tenure) {		
		LoanRepaymentService pesObj = new LoanRepaymentService();
		Repayment obj = null;
		double p = principleAmount;
		double r = interestRate/12;
		double t = tenure * 12;
		double emi = pesObj.calMonthlyEmi(p,r,t);		//emi = (p*r*Math.pow(1+r,t))/(Math.pow(1+r,t)-1);
		double outstanding = p;				
//		List<ArrayList<Double>> listOfLists = new ArrayList<ArrayList<Double>> ();
		for(int i=0;i<t;i++){
			double mInterest = pesObj.calInterest(outstanding,r) ;//rate is monthly //= outstanding * r;			
			double paidPrinciple = pesObj.calPaidPrinciple(emi,mInterest);//emi - mInterest;			
			outstanding = outstanding - paidPrinciple;				
//			ArrayList<Double> t = new ArrayList<>();
//			temp.add(mInterest);
//			temp.add(paidPrinciple);
//			temp.add(balance);			
			obj.setInterest(mInterest);
			obj.setOutstanding(outstanding);
			obj.setPrinciple(paidPrinciple);
			repaySchedule.add(obj);			
			}	
		}
	
	
}


