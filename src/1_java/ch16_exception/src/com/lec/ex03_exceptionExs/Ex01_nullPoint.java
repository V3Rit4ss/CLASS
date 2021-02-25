package com.lec.ex03_exceptionExs;

public class Ex01_nullPoint {
	public static void main(String[] args) {
		String gretting = "Hello";
		System.out.println(gretting.toUpperCase());
		gretting = null;
		System.out.println(gretting.toUpperCase());
	}
}
