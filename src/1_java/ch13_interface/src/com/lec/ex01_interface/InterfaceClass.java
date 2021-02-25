package com.lec.ex01_interface;
// 한 클래스에 하나만 상속. 인터페이스는 두개 이상 동시 상속 가능. : implements (구현.)
public class InterfaceClass implements Interface_Ex01, Interface_Ex02 {

	@Override//ex01 오버라이드
	public void method1() {
		System.out.println("실제 구현은 implements 한 클래스에서 해요.");
		
	}

	@Override//ex02 오버라이드
	public String method2() {
		System.out.println("실제 구현은 implements 한 클래스에서 해요.");
		return null; //스트링 으로 했으면 스트링 아니면 기본값 null로 해도 댐.
	}

}
