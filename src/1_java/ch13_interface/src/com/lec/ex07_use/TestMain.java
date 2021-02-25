package com.lec.ex07_use;
//객체의 부품화.  ab 가 싫으면  I 를 인플로이먼트 하는 새로운 C를 만들어서 추가하면 된다.  이렇게 하기위해서 형을 일치시킨다.
public class TestMain {
	public static void main(String[] args) {
		User user = new User();
		A a = new A();
		B b = new B();
		user.aorbUse(a);
		user.aorbUse(b);
	}
}


