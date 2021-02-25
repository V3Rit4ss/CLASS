package com.lec.ex03_abstract;

public abstract class ChildClass extends SuperClass { //오버라이드를 하던지 추상클래스를 넣던지.
	//SuperClass 로 부터 받은 추상 메소드 method1() 이 있기에  오버라이드 안했음. 
	@Override
	public void method2() { //일반 메소드도 만들수있음.
		System.out.println("ChildClass 의 method2()");
	}
	public void method3() {
		System.out.println("ChildClass 의 method3()");
	}
}

//SuperClass 부분에 있던것.
//	public abstract void method1(); //추상 메소드
//	public void method2() {
//		System.out.println("SuPer의 method2()");
//	}