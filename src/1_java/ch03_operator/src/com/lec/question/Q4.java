package com.lec.question;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println(a>=65 ? "경로우대":"일반");
		sc.close();
	}
}
