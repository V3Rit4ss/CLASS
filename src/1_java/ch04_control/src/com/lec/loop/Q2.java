package com.lec.loop;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("원하시는 구구단을 입력하시오. : ");
		int dansu = sc.nextInt();
		for(int i=1; i<10 ; i++) {
			System.out.printf("%d*%d=%2d\n", dansu, i ,dansu*i);
//			System.out.println(dansu+"*"+i+"="+(dansu*i));
		}
		sc.close();
	}
}
