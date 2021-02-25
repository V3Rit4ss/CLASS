package com.lec.ex06_account;

public class ATM_cardTestMain {
	public static void main(String[] args) {
		Account account = new Account (2000);
		Runnable target1 = new ATM_card(account);
		Thread mom = new Thread(target1, "mom");
		Thread dad = new Thread(target1, "dad");
		
		mom.start();
		dad.start();
	}
}
