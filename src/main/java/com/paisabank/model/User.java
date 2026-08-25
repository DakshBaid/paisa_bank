package com.paisabank.model;

import java.sql.Timestamp;

public class User {

    private int accountNumber;
    private String fullName;
    private String email;
    private String mobile;
    private String password;
    private double balance;
    private String accountStatus;
    private Timestamp createdAt;
   
    public User(int accountNumber,
            String fullName,
            String email,
            String mobile,
            String password,
            double balance,
            String accountStatus,
            Timestamp createdAt) {

    this.accountNumber = accountNumber;
    this.fullName = fullName;
    this.email = email;
    this.mobile = mobile;
    this.password = password;
    this.balance = balance;
    this.accountStatus = accountStatus;
    this.createdAt = createdAt;
}

	public User(String fullName,
            String email,
            String mobile,
            String password
            ) {
		 this.fullName = fullName;
		    this.email = email;
		    this.mobile = mobile;
		    this.password = password;
		   	
	}
	
	public User() {
		
	}
	
	

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
