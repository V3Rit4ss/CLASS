package com.lec.ex01_list;

public class Customer {
	private String name;
	private String phone;
	private String address;
	
	//new customer ("ȫ","010","seoul");
	public Customer(String name, String phone, String address) { //��,�� �ʿ��ϸ� �ֱ�.
		
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	@Override
	public String toString() {
		
		return name +"\t"+ phone +"\t"+address;
	}
	
}
