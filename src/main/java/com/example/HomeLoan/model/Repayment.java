package com.example.HomeLoan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "repayment")
public class Repayment {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer repaymentid;
	
	@Column(name = "loan_account_id")
	private Long accountNo;
	
	@Column(name="date")
	private java.sql.Date date;
		
	@Column(name="emi")
	private Double emi;
	
	@Column(name="principle")
//	Paid this month
	private Double principle;	   
    
	
	@Column(name="interest")
//	Paid this month
	private Double interest;
	

	@Column(name="rate")
	private Double rate;
	
	
	@Column(name="outstanding")
//	Balance loan
	private Double outstanding;
	
		
	@Column(name="status")
	private String status;
	
	
	private List<Repayment> paymentList = new ArrayList<Repayment>();
	
	
	public void setRepaymentid(int repaymentid) {
        this.repaymentid =  repaymentid;
    }
    public Integer getRepaymentid() {
        return this.repaymentid;
    } 
    
    public void setloan_account_id(Long accountNo) {
        this.accountNo =  accountNo;
    }
    public Long getloan_account_id() {
        return this.accountNo;
    } 
    public void setdate(java.sql.Date date) {
        this.date =  date;
    }
    public java.sql.Date getdate() {
        return this.date;
    } 
    public void setemi(Double emi) {
        this.emi =  emi;
    }
    public Double getemi() {
        return this.emi;
    }    
    
    public void setprinciple(Double principle) {
        this.principle =  principle;
    }
    public Double getprinciple() {
        return this.principle;
    } 
    public void setinterest(Double interest) {
        this.interest =  interest;
    }
    public Double getinterest() {
        return this.interest;
    }     
    public void setrate(Double rate) {
        this.rate =  rate;
    }
    public Double getrate() {
        return this.rate;
    } 	
    public void setoutstanding(Double outstanding) {
        this.outstanding =  outstanding;
    }
    public Double getoutstanding() {
        return this.outstanding;
    }     
    public void setstatus(String status) {
        this.status =  status;
    }
    public String getstatus() {
        return this.status;
    } 
    	
   
    public List<Repayment> getPaymentList() { return this.paymentList; }
    public void setPaymentList(List<Repayment> paymentList) { this.paymentList = paymentList; }
    public void addAllPayments(List<Repayment> paymentList) { this.paymentList.addAll(paymentList); }

//    @Override
//    public String toString()
//    {
//        return "[" + startDate + "," + initialBalance + "," + interestRate + "," + durationInMonths + "," + futureValue + "," + paymentType + "," + monthlyPayment + "]";
//    }
}
