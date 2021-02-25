package com.lec.ex01_string;

import java.util.Scanner;

//I: checkIn ("반납되었습니다.") 출력 , O : checkOut("대출 되었습니다.") 출력
//x : 종료.
public class Ex04_Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fn;
		while(true) { //화일문 으로 만들었을때.
			System.out.print("I : checkIn, O : checkOut, x : Exit ?");
			fn = sc.next();
			if(fn.equalsIgnoreCase("x")) {
				break;
			}else if(fn.equalsIgnoreCase("i")) {//(fn.equals("i")|| fn.equals("I"))
				System.out.println("반납되었습니다.");
			}else if(fn.equalsIgnoreCase("o")) {
				System.out.println("대출되었습니다");
			}
		}
//		do { 두화일문으로 만들었을시.
//			System.out.print("I : checkIn, O : checkOut, x : Exit ?");
//			fn = sc.next();
//			if(fn.equalsIgnoreCase("i")) {//(fn.equals("i")|| fn.equals("I"))
//				System.out.println("반납되었습니다.");
//			}else if(fn.equalsIgnoreCase("o")) {
//				System.out.println("대출되었습니다");
//			}
//		}while(!fn.equalsIgnoreCase("x")); //!fn 반대의 의미 : x 가 fn 과 같지 않을때 
//		System.out.println("DONE");
	}
}
