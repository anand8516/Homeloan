package com.example.HomeLoan.controller;

import com.example.HomeLoan.HomeLoanApplication;
import com.example.HomeLoan.model.Repayment;
import com.example.HomeLoan.service.RepaymentService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class PaymentsController {
    private static final Logger logger= (Logger) LogManager.getLogger(PaymentsController.class);

    @Autowired
    RepaymentService paymentService;

    @GetMapping("/prepayment/{id}")
    public ResponseEntity<List<Repayment>> getTutorialById(@PathVariable("id") int id) {
        List<Repayment> repayments=paymentService.getpaymentDetails(id);
        if (repayments != null) {
            return new ResponseEntity<>(repayments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/prepayment")
    public ResponseEntity<Double> updatePrepaymentDetails  (@RequestBody Double Amount)
    {

        /*if(Amount<=(3*emi))//get emi from loan table
        {
            Logger.info("")
        }*/
       // logger.info("Month:"+month);
        //Double EMI=paymentService.updateEMIDetails(Amount,month,year);
        //print repayment schedule function call
        //return new ResponseEntity<>(EMI, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
