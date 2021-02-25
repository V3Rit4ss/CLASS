package com.lec.question;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어");
		int kor = sc.nextInt();
		System.out.println("영어");
		int eng =sc.nextInt();
		System.out.println("수학");
		int mat =sc.nextInt();
		int tot = kor + eng + mat;
		// (double)tot /3
		double avg = tot / 3.0;
		System.out.printf("국어 : %3d\n", kor);
		System.out.printf("영어 : %3d\n", eng);
		System.out.printf("수학 : %3d\n", mat);
		System.out.printf("총점 : %d\t평균 : %.2f\n", tot , avg);
		sc.close();
	}
}
