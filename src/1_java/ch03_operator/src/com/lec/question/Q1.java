package com.lec.question;

import java.util.Scanner;  //스캐너 변수 타이핑을 했을때 정보를 가져가는 애들중 하나

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //sc 노란밑줄은 아직도 실행중이기에 하단에 클로즈드 하면 노란밑줄이 사라짐.
		//System.out.println(name.toUpperCase());  //toUpperCase 대문자로 변환
		System.out.print("정수를 입력하세요 : ");
		int i = sc.nextInt();   // 빨간불이 나오는 상태에서 키보드 입력값이 올때까지 기다리는중이다 그래서 하단에 값을 넣고 엔터치면 작동 완료
		System.out.println(i%3==0? "3의 배수입니다":"3의 배수가 아닙니다");
		sc.close();
	}
}
