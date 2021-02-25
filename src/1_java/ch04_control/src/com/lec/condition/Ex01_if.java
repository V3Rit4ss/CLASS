package com.lec.condition;

public class Ex01_if {
	public static void main(String[] args) {
		int i=10, j=20, h=31;
		if (i+j == h) {  //이프는 중괄호로 구별을 해놓는다. 
			System.out.println("i+j는 h입니다");
		}
		if (i>j) {
			System.out.println("i>j입니다");
		}else {
			System.out.println("i>j가 아닙니다");
		}
	}
}
