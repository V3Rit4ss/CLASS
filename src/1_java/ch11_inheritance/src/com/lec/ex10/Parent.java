package com.lec.ex10;
//매개변수 없는 생성자 가  없음.  // 부모클래스에서 매개변수 없는 생성자가 없으면 오류가 나옴.
public class Parent {
	private int i;
	public Parent (int i) {
		super();
		this.i =i;
	}


	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
