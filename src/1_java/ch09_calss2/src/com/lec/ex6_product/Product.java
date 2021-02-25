package com.lec.ex6_product;
//product p1 = new Product();
public class Product {
	private int seriaNo; //객체고유의 번호
	public static int count = 100 ; //그냥 ; 하면 0부터 시작. 카운트를 공유
	public Product() {
		seriaNo = ++count ; //시리얼 넘버가 증가하면서 들어가라
	}
	public void infoString() {
		System.out.println("serialNo="+seriaNo+"\t공유변수 count = "+count);
	}
	public void setSeriaNo(int seriaNo) {
		this.seriaNo = seriaNo;
	}
	public int getSeriaNo() {
		return seriaNo;
	}
}
