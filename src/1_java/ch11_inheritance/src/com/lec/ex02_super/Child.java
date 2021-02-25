package com.lec.ex02_super;

public class Child extends SuperIJ{
	private int total;
	public Child(int i, int j) { //this.i 라는게 다른 파일에 있기에 안댐.
		setI(i);
		setJ(j);
	}
	public void sum() {
		total = getI()+getJ();//total 에 i+j 할당 할것임
		System.out.println("본 객체의 total:"+total);
	}
}
