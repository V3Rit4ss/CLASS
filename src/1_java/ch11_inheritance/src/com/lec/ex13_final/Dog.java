package com.lec.ex13_final;
//final 클래스 : 상속불가.
public final class Dog extends Animal {
	@Override
	public void running() {
		speed += 10;
		System.out.println("강아지가 뛰면서 꼬리를 흔들어요. 현재 속도 : "+speed);
	}
	public void method() {
		System.out.println("method()");
	}
}
