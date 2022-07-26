package com.example.HomeLoan.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HomeLoan.HomeLoanApplication;
import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.model.Repayment;
import com.example.HomeLoan.repo.LoanAccountRepository;

@Service
public class LoanRepaymentService {
	private static final Logger logger = LogManager.getLogger(LoanRepaymentService.class);
	@Autowired
	private LoanAccountRepository repo;
	
	@Autowired
	private utility dateUtility;
		
	public LoanAccount getLoanAccountById(int LoanId) {
		return repo.findByLoanAccId(LoanId);		
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
	
	List<Repayment> repaySchedule = new ArrayList<Repayment>();
	
	public List<Repayment> generateRepaymentSchedule(Date currdate,double principleAmount, double interestRate,double year,double month) {		
		LoanRepaymentService pesObj = new LoanRepaymentService();
		logger.info("Entere generateRepaymentSchedule");
		double p = principleAmount;
		double r = interestRate/12;
		double t = (year * 12) + month;
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
			Repayment obj = new Repayment();
			int monthly_inc = 1 ;
			obj.setOutstanding(outstanding);
			obj.setInterest(mInterest);			
			obj.setPrinciple(paidPrinciple);
			
			obj.setDate(currdate);
//			obj.setDate(currdate + monthly_inc);
//			yyyy-mm-dd
			logger.info(currdate);
			
			repaySchedule.add(obj);		
			}	
			
			return repaySchedule;
		}
	
	
}


