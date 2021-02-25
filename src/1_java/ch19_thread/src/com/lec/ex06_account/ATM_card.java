package com.lec.ex06_account; //계좌공유. 카드는 두개
//Account acc = new Account();
//Runnable mom = new ATM_card(acc);   메인함수에서 할 방식.
//Runnable dad = new ATM_card(acc);
public class ATM_card implements Runnable {
	
	
	
	private boolean flag= false;
	private Account obj;
	public ATM_card(Account obj) {
		this.obj = obj;
	}
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			if(flag) {
				obj.withdraw(1000, Thread.currentThread().getName()); //맘이 찾을지 댇이 찾을지 모름.
				flag = false;
			}else {
				obj.deposit(1000, Thread.currentThread().getName());
				flag = true;
			}//if
		}//for
		
	}//run

}//class
