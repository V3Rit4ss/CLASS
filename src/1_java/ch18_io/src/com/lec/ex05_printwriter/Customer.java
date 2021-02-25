package com.lec.ex05_printwriter;

public class Customer {
	private String name;
	private String tel;
	private String birthday;
	private String address;
	public Customer(String name, String tel, String birthday, String address) {
		
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
		this.address = address;
	}
	@Override
	public String toString() {
		return name+"\t"+ tel+"\t"+ birthday+"\t"+ address+"\r\n";
	}
	
	
}
