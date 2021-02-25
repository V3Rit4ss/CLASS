package com.lec.ex;

public class varEx02_04 {
	public static void main(String[] args) {
		// 변수 선언 방법
		//1. 자료형 변수명;
		int num1; // 선언만 하고 값의 할당을 안함.
		num1 = 10;
		System.out.println("num1="+num1);
		// 2. 자료형 변수명 = 값;
		char c1 = '씨'; //'응' 는 문자 한글자  "안녕" 는 문자 두개
		System.out.println("c1="+c1);
		// 3. 자료형 변수명1, 변수명2, ... 변수명n;
		boolean b1, b2, b3;  //0 이냐 1이냐 같은거 밖에 트루 or 풰일즈
		b1 = true; b2=false; b3 = true; //자바에서는 분리값만. b3 = 1; 이거 안댐
		System.out.print("b1="+b1+"\t b2="+b2+"\t b3="+b3+"\n");
		// 4. 자료형 변수명1=값1, 변수명2=값,... 변수명n=값n;
		long l1 = 22000000000L; // L 롱 22억자리보다 더 많이 포함.
		float f1 = 1.19f, f2=2.22f, f3; //f 플로트 는 짧은 소숫점 , double 아주 긴 소숫점 까지 표기.
		System.out.println("f1="+f1+"\t f2="+f2);
		System.out.printf("f1 = %3.1f, f2 = %4.1f\n",f1, f2); //%f 에 소숫점 자리 지정 할수있음.(%n.n) [점도 포함] %3자리 소수중 1자리만 , %4자리 소수중 1 자리만
		// %f : 실수 , %d : 정수(소수점 없는것들 : int,short,byte,long) , %c : 문자 , %x : 16진수
		
		
		System.out.println("프로그램 끝");		
	}//프로그램 끝
}//class 끝
