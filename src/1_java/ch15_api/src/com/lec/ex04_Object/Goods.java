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
		
		return "제품 이름 : " + goodName + "제품 코드 : " + goodCode + "현 재고 수량 : " + stockNum + "가격 : " + price;
		
		
		
	}
	
	
	
	
	
}
