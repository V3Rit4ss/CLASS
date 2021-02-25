package com.lec.ex12_account;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	public Account() {}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account(String accountNo, String onwerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = onwerName;
		this.balance = balance;
	}

	public void deposit(int money) {
		balance += money ;
	}
	public void withdraw(int money) {
		if(balance >= money) {
			balance -= money ;
		}else {
			System.out.println("ÀÜ¾×ÀÌ ºÎÁ·ÇÕ´Ï´Ù.");
		}
	}
	public void printAccount() {
		System.out.println("°èÁÂ¹øÈ£:"+accountNo+","+ownerName+"´Ô ÀÜ¾×Àº" + balance);
		
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
