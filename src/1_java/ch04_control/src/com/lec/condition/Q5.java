package com.lec.condition;

import java.util.Scanner;

public class Q5 { //if 와 스위치 복습.
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(" 학점을 입력.");
		int jumsu = scanner.nextInt();
		int temp = jumsu==100 ? jumsu-1 : jumsu;
		switch (temp/10) {
		case 9:
			System.out.println("a"); break;
		case 8:
			System.out.println("b"); break;
		case 7:
			System.out.println("c"); break;
		case 6:
			System.out.println("d"); break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			System.out.println("f"); break;
		default:
			System.out.println("유호하지않음");
		}
		scanner.close();
	}
}
