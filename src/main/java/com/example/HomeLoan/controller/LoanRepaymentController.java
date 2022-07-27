
package com.example.HomeLoan.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.HomeLoan.service.LoanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

	@Autowired
	private LoanAccountService loanAccountService;

	@GetMapping(value = "/loanscheduler")
	public ResponseEntity<?> findLoandetais(HttpSession session) {		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("loanScheduleObject",  loanservice.getLoanAccounts());
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	@PostMapping(value = "/loanscheduler/{id}/")
	public ResponseEntity<?> findLoanSchedulebyID(@Valid @PathVariable int id) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("loanScheduleObject",  loanservice.getLoanSchedulebyID(id));
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	@PostMapping(value = "/loanndetails/{id}/")
	public ResponseEntity<?> findLoandetaisbyID(@Valid @PathVariable int id,HttpSession session) {			
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("loanDetailsObject",  loanservice.getLoanAccountById(id));
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	@PostMapping("/loanndetails/csvexport/{loanid}")
    public void exportToCSV(@Valid @PathVariable int loanid,HttpServletResponse response) throws IOException {
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
