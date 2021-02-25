package com.lec.ex01_interface;
//public 상수와 추상메소드만 올 수 있습니다.    // 부분 블러처리 컨 +쉬 +/   해제 : 컨+쉬+\
public interface Interface_Ex01 {
	//public static final 만 오는 인터페이스.
	public /* static final 생략 가능. */  int CONSTANT_NUM = 10;

	public /* abstract 생략 가능. */ void method1(); //일반 메소드 불가 -> public void method1()}
}
