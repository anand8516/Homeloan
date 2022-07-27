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
import com.example.HomeLoan.repo.RepaymentRepository;

@Service
public class LoanRepaymentService {
	private static final Logger logger = LogManager.getLogger(LoanRepaymentService.class);

	@Autowired
	private LoanAccountRepository loanaccountRepo;
	private LoanAccountRepository repo;

	@Autowired
	private SavingAccountRepositiory savingAccRepo;



	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private RepaymentRepository loanRepaymentRepo;


	public List<LoanAccount> getLoanAccounts() {
		return loanaccountRepo.findAll();
	}



	public LoanAccount getLoanAccountById(int id) {
//		LoanAccount LoanAccountdetails = loanaccountRepo.findById(LoanId);
		return loanaccountRepo.findByLoanAccId(id);
	}

	public List<Repayment> getLoanSchedulebyID(int LoanId) {
		return loanRepaymentRepo.findRepaymentDetailsByAccountNo(LoanId);
	}

	public String updateRepayment(int LoanId) {
		
		List<Repayment> existingPayment = loanRepaymentRepo.findRepaymentDetailsByAccountNo(LoanId);
//		int count = 0;
		int count = 0;
		for (Repayment product : existingPayment) {
			   if(product.getStatus() == "Paid") {
				   ++count;
			   }
	        }

		logger.info("-----------"+count+"-----------------");
		if(count>=3) {

		   logger.info("----------------------------");

		   for (Repayment product : existingPayment) {
			   product.setOutstanding(0.0);
			   product.setStatus("Closed");
			   product.setPrinciple(0.0);
			   product.setInterest(0.0);
			   loanRepaymentRepo.save(product);
			   logger.info("-----------Upated-----------------");
	        }

	       return "Successfylly updated";
	   }
		else
		{
		return "Paid EMIs is less than 3 months";
		}
		
//		return existingPayment;
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

		
		for(int i=0;i<t+1;i++){
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
			
//			logger.info(emi+ " | " +mInterest + " | " + paidPrinciple + " | " +outstanding);
			
			repaySchedule.add(obj);		
			}				
			return repaySchedule;
		}
	public String updateEMIDetails(int loanaccountno,Double amount)
	{
		LoanRepaymentService pesObj = new LoanRepaymentService();

		LocalDate currentDate= LocalDate.now();
	int paidmonthscount=jdbcTemplate.queryForObject("select COUNT(*) from repayment where loan_account_id=? and status='paid'",new Object[]{loanaccountno},Integer.class);
	logger.info("count"+paidmonthscount);
	logger.info("date"+currentDate);
	if(paidmonthscount>=3) {

		String currentmonthemi = "select date,interest,principle,outstanding,emi from repayment where loan_account_id = ?  and status='paid' and date <= ? order by date DESC limit 1";
		Repayment repayment = (Repayment) jdbcTemplate.queryForObject(currentmonthemi, new Object[]{loanaccountno, currentDate},
				new BeanPropertyRowMapper(Repayment.class));

		System.out.println(repayment);
		Date emiDate = repayment.getDate();
		double outstanding = repayment.getOutstanding();
		double rate = 7.0 / 1200;
		int tenuremonths = repo.findByLoanAccId(loanaccountno).getYear() * 12 + repo.findByLoanAccId(loanaccountno).getMonth();
		double balance = outstanding - amount;//prepayment done
		int pendingmonths = tenuremonths - paidmonthscount;
		double newemi = (balance * rate * Math.pow(1 + rate, pendingmonths)) / (Math.pow(1 + rate, pendingmonths) - 1);
		for (int i = 0; i < pendingmonths + 1; i++) {
			double updatedInterest = balance * rate;
			double updatedPrinciple = newemi - updatedInterest;
			balance = balance - updatedPrinciple;
			System.out.println("emi:" + newemi + "interest:" + updatedInterest + "monthlyprinciple" + updatedPrinciple);

			int monthly_inc = 1;
			Date new_date = pesObj.addMonths(emiDate, monthly_inc + i);
			logger.info("new date:" + new_date);

			String updateSQL = "update repayment set emi=?,interest=?,outstanding=?,principle=? where date=? and loan_account_id=? and status!='paid'";
			jdbcTemplate.update(updateSQL, newemi, updatedInterest, balance, updatedPrinciple, new_date, loanaccountno);
		}

		return "prepaymentdone,outstanding balance"+(outstanding-amount);
	}
	else
	{
		return "Cannot prepay ";
	}



	}

	public String emiPayment(int loanaccountno)
	{

			LoanAccount loanAccount=repo.findByLoanAccId(loanaccountno);
			long saving_acc_no=loanAccount.getAccountNo();

			logger.info("saving accountno:"+saving_acc_no);
		SavingAccount userAccount = savingAccRepo.findByAccountno(saving_acc_no);
		logger.info("useraccount"+userAccount);
			Double currentBalance=userAccount.getBalance();


		String currentmonthemi="select id as repaymentid,date,interest,principle,outstanding,emi from repayment where loan_account_id = ?  and status='pending' order by date ASC limit 1";
		Repayment repayment=(Repayment)jdbcTemplate.queryForObject(currentmonthemi,new Object[]{  loanaccountno },
				new BeanPropertyRowMapper(Repayment.class));
		logger.info("repayment"+repayment);
		if(currentBalance>repayment.getEmi()) {
			Double balanceafterDeduction = currentBalance - repayment.getEmi();
			int repayId = repayment.getRepaymentid();

			jdbcTemplate.update("update repayment set status='paid' where loan_account_id=? and id=?", loanaccountno, repayId);
			jdbcTemplate.update("update savingaccount set curr_balance=? where acc_no=?", balanceafterDeduction, saving_acc_no);
			logger.info("EMI deducted");
			return "EMI deduct success";
		}
		else
		{
			return "not enough balance";
		}


	}


}


