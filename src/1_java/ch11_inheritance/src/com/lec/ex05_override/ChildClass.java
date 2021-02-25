package com.lec.ex05_override;

public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("C 매개변수 없는 생성자");
	}
	public ChildClass(int i) {
		System.out.println("C 매개변수 있는 생성자");
	}
	@Override
	public void method1() {
		System.out.println("Child mathod1()");
	}
	public void method3() {
		System.out.println("Child 의 method()");
	}
}
