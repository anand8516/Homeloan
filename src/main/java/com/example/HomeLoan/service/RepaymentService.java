package com.example.HomeLoan.service;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.HomeLoan.model.Repayment;

import com.example.HomeLoan.repo.RepaymentRepository;
@Service
public class RepaymentService {
	private static final Logger logger = LogManager.getLogger(RepaymentService.class);
	
	
//	private JpaRepository Paymentrep;
	@Autowired
	private RepaymentRepository rep;
	
	@Autowired
	private LoanRepaymentService LRS;

	public String updateRepayment(int loanAccId)
	{
					
		long count = 4L ;//rep.NumbeOfEmi(loanAccId);
		logger.info("count | " + count);
		logger.info(count);				
		if(count>=3L) {								
		   List<Repayment> existingPayment = LRS.getLoanSchedulebyID(loanAccId);
		   logger.info("-------------"+existingPayment+"---------------");		   
//		   for(long i=0;i<count;i++) {
//			   existingProduct.setOutstanding(0.0);
//			   existingProduct.setStatus("Closed");
//			   existingProduct.setPrinciple(0.0);
//			   existingProduct.setInterest(0.0);
//		   }
		   
		   for (Repayment product : existingPayment) {
			   product.setOutstanding(0.0);
			   product.setStatus("Closed");
			   product.setPrinciple(0.0);
			   product.setInterest(0.0);
			   rep.save(product);
	        }
	     
	       return "Successfylly updated ";
	   }
		else
		{
		return "Paid EMIs is less than 3 months ";
		}
	
	}
}
