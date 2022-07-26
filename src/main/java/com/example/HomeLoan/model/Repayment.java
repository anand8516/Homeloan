package com.example.HomeLoan.model;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer repaymentid;
	
	@Column(name = "loan_account_id")
	private Long accountNo;
	
	@Column(name="year")
	private int year;

	@Column(name="month")
	private int month;
	
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
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

	@Override
	public String toString() {
		return "Repayment{" +
				"repaymentid=" + repaymentid +
				", accountNo=" + accountNo +
				", year=" + year +
				", month=" + month +
				", emi=" + emi +
				", principle=" + principle +
				", interest=" + interest +
				", rate=" + rate +
				", outstanding=" + outstanding +
				", status='" + status + '\'' +
				'}';
	}
}
