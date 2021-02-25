package com.lec.ex;
public class varEx05_06 {
	public static void main(String [] args) {  //String = 문자열. 기본데이타타입(기본자료형)은 소문자 , 아니면 대문자. 즉 : 참조데이터 타입(참조자료형,객체자료형)
		float f; double d;
		f = 3.14159265359f; // 0.010*10의 2승 : 0.101E2
		d = 3.14159265359; //실수 데이터는 double 로 하는게 좋다.
		System.out.println(f); // 소수점 두자리까지
		System.out.println(d); // 소수점 두자리까지
		f = 10.001f;
		d = 10.001;
		System.out.println("f="+f);
		System.out.println("d="+d);
		if(f==d)  // == : 두개의 주머니가 같은 값이냐  // if 선언값이 무엇일때
			System.out.println("둘이 같다");
		else  // if의 값이 아닐때
			System.out.println("둘이 다르네");
	}
}





