package com.example.HomeLoan.model;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "loan_account")
@AllArgsConstructor
@NoArgsConstructor
public class LoanAccount {
	
	@Id
	@Column(name = "loan_acc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanAccId;
	

	@Column(name = "saving_acc_no")
	@NotNull(message = "please select saving account")
	private long accountNo;
	
	@NotNull(message = "please fill loan_amount")
	@Column(name="loan_amount")
	private Double amount;
	
	@NotNull(message = "please fill interest rate")
	@Column(name="interest_rate")
	private Double interestRate;
	
	@NotNull(message = "please fill salary")
	@Column(name="salary")
	private Double salary;
	
	@NotNull(message = "please fill year")
	@Column(name="year")
	private int year; 
	
	@NotNull(message = "please fill month")
	@Column(name="month")
	private int month; 
	
	@NotBlank(message = "please fill address")
	@Lob  //Large Objects
	private String description;
	
	@Column(name="status")
	private String status;
	
	@Column
	
	private String file;

	
	
	public LoanAccount() {
		super();
	}


	public LoanAccount(Integer loanAccId, long accountNo, Double amount, Double interestRate, Double salary, int year,
			int month, String description, String status, String file) {
		super();
		this.loanAccId = loanAccId;
		this.accountNo = accountNo;
		this.amount = amount;
		this.interestRate = interestRate;
		this.salary = salary;
		this.year = year;
		this.month = month;
		this.description = description;
		this.status = status;
		this.file = file;
	}


	public Integer getLoanAccId() {
		return loanAccId;
	}

	public void setLoanAccId(Integer loanAccId) {
		this.loanAccId = loanAccId;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long string) {
		this.accountNo = string;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
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


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	
	
	

}
