package com.lec.ex03_abstract;

public class TestMain {
	public static void main(String[] args) {
//		SuperClass sup = new SuperClass(); 불가
		//ChildClass Child = new ChildClass(); 불가
		SuperClass sup = new GrandChildClass();
		sup.method1();
		sup.method2();
//		sup.method3(); 변수의 타입이 달라 불가. 변수의 타입을 바꾸면 가능하긴함.
		ChildClass child = new GrandChildClass();
		child.method1();
		child.method2();
		child.method3();
		GrandChildClass grand = new GrandChildClass();
		grand.method1();
		grand.method2();
		grand.method3();
	}
}
