package com.lec.ex04;

public class TestMain {
	public static void main(String[] args) {
		TestChildClass test = new TestChildClass();
		System.out.println(test.i1+" , "+test.i2);
		System.out.println(test.i3+" , "+test.i11);
		System.out.println(I1.i1);//위보다는 아래 클래스 이름으로 하지 않을래? (무시 가능.)
		test.m1();
		test.m2();
		test.m3();
		test.m11();
		TestClass cTest = test;  //객체 바꿈.
	}
}
