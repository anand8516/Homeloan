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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer repaymentid;
	
	@Column(name = "loan_account_id")
	private Long accountNo;
	
	@Column(name="year")
	private int year;
	
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

}