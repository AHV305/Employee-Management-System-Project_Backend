package com.ahv.banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="accounts")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="account_holder_name")
	private String accoutnHolderName;
	private double balance;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccoutnHolderName() {
		return accoutnHolderName;
	}
	public void setAccoutnHolderName(String accoutnHolderName) {
		this.accoutnHolderName = accoutnHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(Long id, String accoutnHolderName, double balance) {
		super();
		this.id = id;
		this.accoutnHolderName = accoutnHolderName;
		this.balance = balance;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accoutnHolderName=" + accoutnHolderName + ", balance=" + balance + "]";
	}
}
