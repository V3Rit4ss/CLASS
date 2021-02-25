package com.tj.account;
/* 은행계좌 클래스 
 * (데이터 : 계좌번호 accountNo:String[111-222-222222] , 예금주 ownerName:String, 잔액 balance:int )
 * 메소드 : 예금한다 (void deposit(int money)) , 인출하다 (int or void withdraw(int moeny)) 
 * new Account("111-111-222222", "홍" , 10)
 */
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
		this.ownerName=onwerName;
		this.balance =balance;
	}
	public void deposit(int money) { //예금은 무조건
		balance += money ;
	}
	public void withdraw(int money) { //잔액 부족시 -1 return // void 를 해서 글자로 표시해주기
		if(balance >= money) {
			balance -= money; //balance = balance -money;
		}else {
			System.out.println("잔액이 부족합니다.");
		}		
	}
	public void info() {
		System.out.println("계좌번호:"+accountNo+","+ownerName+"님 잔액은" + balance);
	}
	//accountNo, onwerName , balance setter&getter
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo ;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setOnwerName(String onwerName) {
		this.ownerName = onwerName ;
	}
	public String getOnwerName() {
		return ownerName;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
}
