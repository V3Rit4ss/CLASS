package com.lec.ex01_tryCatch;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i , j;
		System.out.print("첫번째 수는 ?");
		i = sc.nextInt();
		System.out.print("두번째 수는 ?");
		j = sc.nextInt();
		System.out.println("i = "+i+", j = "+j );
		System.out.println("i * j = "+ (i*j) );
		try {//예외발생부분에 씌워주기
			
		System.out.println("i / j = "+ (i/j) );
		
		}catch(ArithmeticException e) {//ArithmeticException "변수" 여기서 멈추지말고 위회해서 다음껄 실행해라.
			
			//e.printStackTrace(); //예외사항을 자세히 출력해줌.
			System.out.println(e.getMessage()); //예외사항의 메세지만 출력.
			
		}
		
		
		System.out.println("i + j = "+ (i+j) );
		System.out.println("i - j = "+ (i-j) );
		System.out.println("DONE");
		sc.close();
		
	}
}
