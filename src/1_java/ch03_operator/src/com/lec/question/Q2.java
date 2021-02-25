package com.lec.question;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int a = sc.nextInt();
		//if (a%2==0)
			System.out.println(a%2==0 ? "짝수":"홀수");
		//else
			
		sc.close();
		
	}
}
