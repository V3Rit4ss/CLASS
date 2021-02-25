package com.lec.ex04_account;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	public Account() {	}
	public Account(String accountNo, String ownerName) {
		
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account(String accountNo, String ownerName, int balance) {
		
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	//예금하는 메소드
	public void deposit(int amount) { //예금시 : 계좌정보 출력 -> 예금 -> 예금후 계좌정보 출력
		//Account a= new Account("11-11","홍")
		// a.deposit(10)  -> 여기서의 this == a
		System.out.println("예금전 : "+this);
		balance += amount;
		System.out.println(amount+"원 예금후 : "+this);
		
	}
	//출금 : 계좌정보 출력 -> 출금 -> 출금후 계좌정보 출력
	public void withdraw(int amount) throws Exception {
		if(balance<amount) {//잔액부족으로 강제 예외발생.
			throw new Exception(amount+"원 출금하기에는 잔액("+balance+")이 부족합니다.");
		}
		System.out.println("출금전 :"+this);
		balance -= amount; //발란스 = 발란스 - 어마운트 ;
		System.out.println(amount+"원 출금후 : "+this);
		
		
	}
	@Override
	public String toString() {
		String result = "계좌번호 : "+accountNo + "\t 예금주 : "+ownerName;
		result += "\t 잔액: "+balance;
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
