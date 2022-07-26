package com.example.HomeLoan.service;

import com.example.HomeLoan.model.Repayment;
import com.example.HomeLoan.repo.PaymentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {



    @Autowired
    PaymentsRepo paymentsRepo;
    @Autowired
    JdbcTemplate jdbcTemplate;


    public Repayment findRepaymentByloanaccountno(int loanaccountno)
    {

    }





    public List<Repayment> getpaymentDetails(int loanaccountno) {

        String sql="select * from repayment where id=?";
        List<Repayment> customers = jdbcTemplate.query(
                sql,new Object[]{loanaccountno},
                new BeanPropertyRowMapper(Repayment.class));

        System.out.println(customers);

        return customers;


    }

    public Double updateEMIDetails(Double amount,int month,int year)
    {
        int loanaccountno=1;// get loan account id from loan table with help of logged in user

        String deleteoldentries="delete from repayment where month>=? & year=?";
        String deleteallentries="delete from repayment where year>?";
        String emiupdate ="select from repayment where month>=? && status=paid";

        Repayment repayment=(Repayment)jdbcTemplate.queryForObject("",new Object[]{loanaccountno},
                new BeanPropertyRowMapper(Repayment.class));
       /* outstandingamount=
        double p=outstandingAmount;
        double r=interestRate/1200;
        double t=tenure*12;
        double newemi=(p*r*Math.pow(1+r,t))/(Math.pow(1+r,t)-1);
        double balance=p;
        for(int i=0;i<t;i++)
        {
            double mInterest=balance*r;
            double mPrinciple=newemi-mInterest;
            balance=balance-mPrinciple;
            String updateschedule="update repayment set "

        }
        String INSERT_USERS_SQL = "INSERT INTO users" + "  (id, name, email, country, password) VALUES " +
                " (?, ?, ?, ?, ?);";*/


    }

    @Override
    public List<Repayment> findAll() {
        return null;
    }
}
