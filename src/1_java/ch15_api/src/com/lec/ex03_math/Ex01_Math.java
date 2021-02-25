package com.lec.ex03_math;
//다 스태틱 파이널 변수.
public class Ex01_Math {
	public static void main(String[] args) {
		System.out.println("2의 10승은 "+Math.pow(2, 10));
		System.out.println("-9.9의 절대값은"+Math.abs(-9.9));
		System.out.println("16의 제곱근은"+Math.sqrt(16));
		System.out.println("1,2의 최솟값은"+Math.min(1, 2));
		System.out.println("1,2의 최댓값은"+Math.max(1, 2));
		//Math 의 변수 [static final 변수]
		System.out.println("pi값은"+Math.PI);
		System.out.println("sin(PI)"+Math.sin(Math.PI));
		System.out.println("cos(PI)"+Math.cos(Math.PI));
	}
}
