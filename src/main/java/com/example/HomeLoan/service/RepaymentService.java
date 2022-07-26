package com.example.HomeLoan.service;

import com.example.HomeLoan.model.Repayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class RepaymentService {



    @Autowired
    LoanAccountService loanAccountService;
    @Autowired
    JdbcTemplate jdbcTemplate;




    public List<Repayment> getpaymentDetails(int loanaccountno) {

        String sql="select * from repayment where id=?";
        List<Repayment> customers = jdbcTemplate.query(
                sql,new Object[]{loanaccountno},
                new BeanPropertyRowMapper(Repayment.class));

        System.out.println(customers);

        return customers;


    }

    public Double updateEMIDetails(Double amount)
    {

        int loanaccountno=loanAccountService.getLoanDetails(101).getLoanAccId();// get loan account id from loan table with help of logged in user
        LocalDate currentDate= LocalDate.now();
        int currentmonth=currentDate.getMonthValue();
        int currentyear=currentDate.getYear();

        int paidmonthscount=jdbcTemplate.queryForObject("select COUNT(*) from repayment where accountNo=? and status='paid'",new Object[]{loanaccountno},Integer.class);

        String currentmonthemi="select date,interest,principle,outstanding,emi from repayment where accountNo=? and status='paid' and date>? order by date ASC limit 1";
        Repayment repayment=(Repayment)jdbcTemplate.queryForObject("currentmonthemi",new Object[]{loanaccountno,currentDate},
                new BeanPropertyRowMapper(Repayment.class));
        System.out.println(repayment);
        Date emiDate=repayment.getDate();
        int month=emiDate.getMonth();
        int year=emiDate.getYear();
        double outstanding=repayment.getOutstanding();
        double rate= repayment.getRate()/12;
        int tenuremonths=loanAccountService.getLoanDetails(101).getYear()*12+loanAccountService.getLoanDetails(101).getMonth();
        double newemi=(outstanding*rate*Math.pow(1+rate,tenuremonths))/(Math.pow(1+rate,tenuremonths)-1);
        double balance=outstanding;
        int pendingmonths=tenuremonths-paidmonthscount;
        for(int i=0;i<pendingmonths;i++)
        {
            double monthlyInterest=balance*rate;
            double monthlyPrinciple=newemi-monthlyInterest;
            balance=balance-monthlyPrinciple;
            System.out.println("emi:"+newemi+"interest:"+monthlyInterest+"monthlyprinciple"+monthlyPrinciple);
            //String updateEMI="replace into repayment(loan_account_id,date,emi,interest,outstanding,principle,rate,status,updated_at)values(?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(updateEMI,101,)
                update repayment set emi=?,interest=?,outstanding=?,principle=? where date like
            jdbcTemplate.update(updateEMI,);
        }
        String INSERT_USERS_SQL =

        return 5.0;
    }


}
