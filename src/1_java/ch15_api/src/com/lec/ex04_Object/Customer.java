package com.lec.ex04_Object;

public class Customer {
	private String name;
	private String tel;
	private int amount;
	private int point;
	public Customer(String name, String tel) {
		this.name = name;
		this.tel = tel;
		
		
		point = 3000;
		
		
	}
	@Override
	public String toString() {
		String post = tel.substring(tel.lastIndexOf("-")+1);
		return name+"("+ post +")"+ "누적금액 : "+amount + "포인트 : "+point;
		
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj != null && obj instanceof Customer) {
//			boolean nameChk = this.name == ((Customer)obj).name;
//			boolean telChk = this.tel == ((Customer)obj).tel;
			return tel.equals(((Customer)obj).tel);
//			return nameChk && telChk;
		}
		return false;
		
		
		
	}
	
	
}
