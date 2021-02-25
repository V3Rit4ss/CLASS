package com.lec.ex01_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

//트라이 절의 블럭을 최소한으로만 씌운다.
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i , j = 1;
		do {
			try {
				System.out.print("첫번째 수는 ?");
				i = sc.nextInt();
				break;
			}catch(InputMismatchException e) {  //Exception 부모 클래스이니  ArithmeticException 대신 쓰는거 가능.
				
				System.out.println(e.getMessage());
				System.out.println("첫번째 수에 문자를 넣지 마세요.");
				sc.nextLine(); //버퍼를 지우는 목적.  ?\n  를 삭제.
			}
		}while(true);
		System.out.print("두번째 수는 ?");
		try {
			
			j = sc.nextInt();
			System.out.println("i = "+i+", j = "+j );
			System.out.println("i * j = "+ (i*j) );
			//try {//트라이안에 트라이 넣기 가능.
			System.out.println("i / j = "+ (i/j) );
		}catch(ArithmeticException e){  //Exception 최고 상속클래스이기때문에 넣을라면 맨 아래로.
			
			System.out.println(e.getMessage()+"0으로 나누는 것은 패스");
			
		}catch(InputMismatchException e) { //예외발생시에만 실행
			
			System.out.println(e.getMessage());
			System.out.println("두번째 수를 잘못입력해서 1로 초기화 함");
			//j=1; 여기도 가능.
		}catch (Exception e) {
			System.out.println(e.getMessage()+"무슨 에러일까?");//Exception 최고 상위클래스이기때문에 넣을라면 맨 아래로.
		}
		System.out.println("i + j = "+ (i+j) );
		System.out.println("i - j = "+ (i-j) );
		System.out.println("DONE");
		sc.close();
		
	}
}
