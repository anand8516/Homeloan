package com.example.HomeLoan.service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.model.Repayment;
import com.example.HomeLoan.repo.LoanAccountRepository;
//import com.example.HomeLoan.repo.LoanRepayScheduleRepository;
//import com.example.HomeLoan.repo.LoanScheduleRepository;

@Service
public class LoanRepaymentService {
	private static final Logger logger = LogManager.getLogger(LoanRepaymentService.class);
	
	@Autowired
	private LoanAccountRepository loanaccountRepo;
	
//	@Autowired
//	private LoanRepayScheduleRepository loanScheduleRepo;
	
	@Autowired
	private utility dateUtility;
	
	public List<LoanAccount> getLoanAccounts() {
		return loanaccountRepo.findAll();		
	}
	
	public LoanAccount getLoanAccountById(int LoanId) {
//		LoanAccount LoanAccountdetails = loanaccountRepo.findById(LoanId);		
		return loanaccountRepo.findByLoanAccId(LoanId);
	}
	
//	public List<Repayment> getLoanSchedulebyID(long LoanId) {		
//		return loanScheduleRepo.findByLoanId(LoanId);
//	}
		
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
	
	public Date addMonths(Date date,int months) {		
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		String s = DATE_FORMAT.format(date);	
		LocalDate localdate = LocalDate.parse(s);
		LocalDate newDate = localdate.plusMonths(months); 		
		System.out.println("New Date : "+newDate);
		Date date_new = Date.from(newDate.atStartOfDay(ZoneId.systemDefault()).toInstant());		
		return date_new;	    
	}
	
	
	public List<Repayment> generateRepaymentSchedule(Date currdate,double principleAmount, double interestRate,double year,double month) {		
		LoanRepaymentService pesObj = new LoanRepaymentService();
		logger.info("Entere generateRepaymentSchedule");
		double p = principleAmount;
		double r = interestRate*0.01/12;
		double t = (year * 12) + month;
		double emi = pesObj.calMonthlyEmi(p,r,t);		//emi = (p*r*Math.pow(1+r,t))/(Math.pow(1+r,t)-1);
		
		double outstanding = p;				

		
		for(int i=0;i<t;i++){
			double mInterest = pesObj.calInterest(outstanding,r) ;//rate is monthly //= outstanding * r;			
			double paidPrinciple = pesObj.calPaidPrinciple(emi,mInterest);//emi - mInterest;			
			outstanding = outstanding - paidPrinciple;				

			Repayment obj = new Repayment();
			int monthly_inc = 1 ;
			obj.setOutstanding(outstanding);
			obj.setInterest(mInterest);						
			obj.setPrinciple(paidPrinciple);
			obj.setEmi(emi);
			
			
			Date new_date = pesObj.addMonths(currdate,monthly_inc + i);
			obj.setDate(new_date);
			
			logger.info(emi+ " | " +mInterest + " | " + paidPrinciple + " | " +outstanding);
			
			repaySchedule.add(obj);		
			}				
			return repaySchedule;
		}
	
	
}


