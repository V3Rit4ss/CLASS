package com.lec.ex03_abstract;

public class GrandChildClass extends ChildClass {
	@Override
	public void method1() {
		System.out.println("GrandChild의 method1()");	
	}
}
//ChildClass  - 추상메소드1() , 메소드2() , 메소드3(). [여기서 추상메소드 1를 다시 재정의 하던지 아니면 본인이 추상클래스로 되던지.]