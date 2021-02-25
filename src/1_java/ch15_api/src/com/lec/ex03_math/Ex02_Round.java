package com.lec.ex03_math;
//
public class Ex02_Round {
	public static void main(String[] args) {
		//반올림   69.56을 반올림해보자
		System.out.println("소숫점에서 반올림, 올림, 버림");
		System.out.println("9.12를 올림 : "+(int)Math.ceil(9.12));//기본은 더블형  (int)를 붙히면 정수로.
		System.out.println("9.12를 반올림 : "+Math.round(9.12));
		System.out.println("9.12를 버림 : "+(int)Math.floor(9.12));
		System.out.println("소숫점 '한자리'에서 반올림,올림,버림"); // (9.15*10)/10 자바에서는 이렇게해야함.
		System.out.println("9.15를 올림 : "+Math.ceil(9.15*10)/10);
		System.out.println("9.15를 반올림 : "+Math.round(9.15*10)/10.0);  //라운드 자체가 인트라서 10.0  '.0' 를 추가. 
		System.out.println("9.15를 버림 : "+Math.floor(9.15*10)/10);
		
		
		System.out.println("일의 자리에서 반올림 , 올림, 버림");
		System.out.println("85를 올림 (90): "+Math.ceil(85/10.0)*10);
		System.out.println("85를 반올림(90) : "+Math.round(85/10.0)*10);
		System.out.println("85를 버림(80) : "+Math.floor(85/10.0)*10);
	}
}
