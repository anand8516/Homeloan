package com.example.HomeLoan.model;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

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
	private Long accountNo;
	
	@Column(name="loan_amount")
	private Double amount;
	
	@Column(name="interest_rate")
	private Double interestRate;
	
	@Column(name="salary")
	private Double salary;
	
	@Column(name="tenure")
	private int tenure; //month or year
	
	@Lob  //Large Objects
	private String description;
	
	@Column(name="status")
	private String status;
	
	@Column
	@Lob
	private byte[] file;
	
	

}
