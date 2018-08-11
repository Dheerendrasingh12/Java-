package com.dheerendra.BankProject;

public class BankAccount {
	private long accNo;
	private String name;
	private double balance;

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void depositeMoney(double dep) {
		balance = balance + dep;
	}
	public void WithdrawMoney(double withdraw) {
		balance=balance-withdraw;
	}
}
