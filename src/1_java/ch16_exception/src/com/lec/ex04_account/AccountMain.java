package com.lec.ex04_account;

public class AccountMain {
	public static void main(String[] args) {
		Account obj1 = new Account("11-11","홍길동");
		Account obj2 = new Account("22-22","이길동",20000);
		obj1.deposit(10000);
		obj2.deposit(10000);
		try { //메소드에서 쓰로우 익셉션 하면 트라이문 해줘야한다.
			obj1.withdraw(15000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
