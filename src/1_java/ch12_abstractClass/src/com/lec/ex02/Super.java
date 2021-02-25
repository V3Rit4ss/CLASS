package com.lec.ex02;
//추상 클래스는 1개이상의 추상메소드를 가져야함. //객체 못만듬.  //당장 쓸꺼면 추상클래스
//Spuer s = new Super(); 불가    추상 클래스는 객체를 생성할수가 없다.
//s.method();           불가
public abstract class Super {
	public Super() {} //디폴트 생성자
	public abstract void method1();  //실상이 없는 추상메소드 
	public void method2() {
		System.out.println("Super의 method2()");
	}
}
