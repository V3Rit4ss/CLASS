package com.lec.ex04;
//i1 ,i2 ,i3  //i3 을 구현(implements)함.
public class TestClass implements I3 { // 메인함수가 아니라 실행 불가.

	@Override
	public void m1() {
		System.out.println("상수 i1 : "+i1);
	}

	@Override
	public void m2() {
		System.out.println("상수 i2 : "+i2);
	}

	@Override
	public void m3() {
		System.out.println("상수 i3 : "+i3);
	}

}
