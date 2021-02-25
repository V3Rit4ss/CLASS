package com.lec.ex12_account;

public class CreditLineAccount extends CheckingAccount {
	private long creditLine;

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}

	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}

	@Override
	public void pay(String cardNo, int amount) {
		if (getCardNo().equals(cardNo)) {
			if (creditLine < amount) {
				System.out.println(getOwnerName() + "님, 한도 초과입니다.");
			} else {
				creditLine -= amount;
				System.out.println(getOwnerName() + "님, " + amount + "원 출금(잔여 한도액 : " + creditLine + "원)");
			}
		} else {
			System.out.println("카드 번호가 일치하지 않습니다.");
		}
	}

	@Override
	public void printAccount() {
		super.printAccount();
		System.out.println("카드 한도액 : "+creditLine);
	}
	public long getCreditLine() {
		return creditLine;
	}
}
