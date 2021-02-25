package com.lec.ex;

import java.util.Scanner;

public class Ex03_ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su = -5 ;
		System.out.println(su+"의 절대값은"+Arithmetic.abs(su));
		
		Arithmetic ar = new Arithmetic(); // Arithmetic 형 객체 생성이 댐.
		int sum = ar.sum(10,51) ;
		System.out.println("합은"+sum);
		System.out.println(ar.evenOdd(sum));
		System.out.println("**********************");
		sum = ar.sum(50);
		System.out.println("합은"+sum);
		System.out.println(ar.evenOdd(sum));
		sc.close();
	}
}
