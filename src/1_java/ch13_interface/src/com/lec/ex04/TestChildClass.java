package com.lec.ex04;

public class TestChildClass extends TestClass implements I11 {

	@Override //i11 때문에 오버라이드함.
	public void m11() {
		System.out.println("상수 i11="+i11);
	}

}
