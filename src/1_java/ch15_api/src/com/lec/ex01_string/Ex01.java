package com.lec.ex01_string;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");//무조건 객체 생성.
		if(str1 == str2) {  //str1 과 str2 의 같은 주소인가
			System.out.println("str1 과 str2 는 같은 주소");
		}else {
			System.out.println("str1 과 str2 는 다른주소");
		}
		
		str1 = "java2"; // str1 의 주소가 java2 로 가리켜서 1과 2의 값이 달라진다.
		if(str1 == str2) {  //str1 과 str2 의 같은 주소인가
			System.out.println("str1 과 str2 는 같은 주소");
		}else {
			System.out.println("str1 과 str2 는 다른주소");
		}
		
		if(str1 == str3) {
			System.out.println("str1 과 str3 는 같은주소");
		}else {
			System.out.println("str1과 str3 는 다른주소");
		}
		System.out.println(str1.hashCode());
		System.out.println("str2와 str3은 같은 스트링이냐?"+(str2.equals(str3)? "같다":"틀리다"));
		
	}
}
