package com.lec.ex06_this;

public class Friend {
	private String name;
	private String tal;
	public Friend () {
		System.out.println("매개변수 0개 짜리");
	}
	public Friend (String name) {
		this();
		this.name = name; //this : 내 객체의.
		//this() : 현 클래스의 생성자 함수
		System.out.println("매개변수 1개짜리");
	}
	public Friend (String name, String tal) {
		this(name);      //this.name = name; 위에있는 것이 호출댐.
		this.tal = tal;
	}
}
