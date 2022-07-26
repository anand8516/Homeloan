
package com.example.HomeLoan.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.model.Repayment;
import com.example.HomeLoan.service.LoanRepaymentService;

@RestController
public class LoanRepaymentController {
	
	@Autowired
	private LoanRepaymentService loanservice;
	
	@GetMapping(value = "/loanscheduler")
	public List<LoanAccount> findLoandetais(HttpSession session) {
		return loanservice.getLoanAccounts();
	}
	
	@PostMapping(value = "/loanscheduler/{id}/")
	public List<Repayment> findLoanSchedulebyID(@PathVariable int id) {
		return loanservice.getLoanSchedulebyID(id);
	}
	
	@PostMapping(value = "/loanndetails/{id}/")
	public LoanAccount findLoandetaisbyID(@PathVariable int id,HttpSession session) {
		return loanservice.getLoanAccountById(id);
	}
	
	@GetMapping("/loanndetails/csvexport/{loanid}")
    public void exportToCSV(@PathVariable int loanid,HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);
         
        List<Repayment> listUsers = loanservice.getLoanSchedulebyID(loanid);
 
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Date", "EMI (Monthly)", "Interest ()", "OutStanding", "Principle","Status"};
        String[] nameMapping = {"date", "emi", "interest", "outstanding", "principle", "status"};
         
        csvWriter.writeHeader(csvHeader);
         
        for (Repayment user : listUsers) {
            csvWriter.write(user, nameMapping);
        }
         
        csvWriter.close();
         
    }
	
}
