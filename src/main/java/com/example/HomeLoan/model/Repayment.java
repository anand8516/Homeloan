package com.example.HomeLoan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

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
	private Double principle;
	
	@Column(name="interest")
	private Double interest;

	@Column(name="rate")
	private Double rate;
	
	@Column(name="outstanding")
	private Double outstanding;
	
	@Column(name="status")
	private String status;
	

	

	@Column(name="updated_at")
	private Date updatedat;

	public Repayment(Integer repaymentid, Long accountNo, java.sql.Date date, Double emi, Double principle,
			Double interest, Double rate, Double outstanding, String status, Date updatedat) {
		super();
		this.repaymentid = repaymentid;
		this.accountNo = accountNo;
		this.date = date;
		this.emi = emi;
		this.principle = principle;
		this.interest = interest;
		this.rate = rate;
		this.outstanding = outstanding;
		this.status = status;

		this.updatedat = updatedat;
	}

	public Integer getRepaymentid() {
		return repaymentid;
	}

	public void setRepaymentid(Integer repaymentid) {
		this.repaymentid = repaymentid;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public Double getEmi() {
		return emi;
	}

	public void setEmi(Double emi) {
		this.emi = emi;
	}

	public Double getPrinciple() {
		return principle;
	}

	public void setPrinciple(Double principle) {
		this.principle = principle;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(Double outstanding) {
		this.outstanding = outstanding;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public Date getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

}