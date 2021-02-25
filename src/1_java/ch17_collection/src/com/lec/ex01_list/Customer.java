package com.lec.ex01_list;

public class Customer {
	private String name;
	private String phone;
	private String address;
	
	//new customer ("È«","010","seoul");
	public Customer(String name, String phone, String address) { //¼Â,°Ù ÇÊ¿äÇÏ¸é ³Ö±â.
		
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	@Override
	public String toString() {
		
		return name +"\t"+ phone +"\t"+address;
	}
	
}
