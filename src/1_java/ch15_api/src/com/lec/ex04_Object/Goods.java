package com.lec.ex04_Object;

public class Goods {
	private String goodName;
	private String goodCode;
	private int stockNum;
	private int price;
	public Goods(String goodName, String goodCode, int stockNum, int price) {
		this.goodName = goodName;
		this.goodCode = goodCode;
		this.stockNum = stockNum;
		this.price = price;
	}
	@Override
	public String toString() {
		
		return "��ǰ �̸� : " + goodName + "��ǰ �ڵ� : " + goodCode + "�� ��� ���� : " + stockNum + "���� : " + price;
		
		
		
	}
	
	
	
	
	
}
