package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) {
		Child c1 = new Child();
		c1.method1();
//		Super c2 = new Child();
		c1.method1();
		c1.method2();
		c1.method3();
		Super c2 = new Child();
		c2.method1();
		c2.method2();
		//Super s;  //변수 선언만 가능.
//		Super s =new Super() {   new Super 에서 컨 + 스페이스바 하고 하면 안드로이드에서만 쓰이는 방법이 나옴.
//			
//			@Override
//			public void method1() {
//				System.out.println("안드로이드에서만 이런거 씀.");	
//			}
//		};
//		s.method1();
	}
}
