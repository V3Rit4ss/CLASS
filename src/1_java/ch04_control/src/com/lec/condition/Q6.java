package com.lec.condition;

import java.util.Scanner;

public class Q6 { //시간(월 , 일)은 사용자가 받는게 아니라 시스템에서 받아야한다. 그건 api 강의때 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("지금 몇 월 인가요 ?");
		int month = scanner.nextInt();
		switch (month) {
		case 12: case 1: case 2:
			System.out.println("입력하신 개월은 겨울이군요"); break;
		case 3: case 4: case 5:
			System.out.println("입력하신 개월은 봄이군요"); break;
		case 6: case 7: case 8:
			System.out.println("입력하신 개월은 여름이군요"); break;
		case 9: case 10: case 11:
			System.out.println("입력하신 개월은 가을이군요"); break;
		default:
			System.out.println("정확한 값을 입력해주세요");
		}
		if(month==12 || month==1 || month==2) {
			System.out.println("입력하신 개월은 겨울이군요");
		}else if(month==3 || month==4 || month==5) {
			System.out.println("입력하신 개월은 봄이군요");
		}else if(month==6 || month==7 || month==8) {
			System.out.println("입력하신 개월은 여름이군요");
		}else if(month==9 || month==10 || month==11) {
			System.out.println("입력하신 개월은 가을이군요");
		}else {
			System.out.println("다시 입력해주세요");
		}
		scanner.close();
	}
}
