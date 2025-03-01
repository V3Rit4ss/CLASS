package com.lec.loop;

import java.util.Scanner;

public class Ex10_dowhile_lotto { // 랜덤넘 에서 카피한 자바 파일. 12-02
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lotto = (int)(int)(Math.random()*45)+1; //컴퓨터 로또 난수
		int su; // 사용자에게 입력받은 수를 저장하는 변수
		int min = 1 ;
		int max = 45 ;
		do {
			System.out.printf("%d부터 %d까지 로또 번호 한개를 알아맞춰 보세요" , min, max);
			su = scanner.nextInt();
			if(su>lotto) {
				System.out.println(su+"보다 작은 수를 도전하세요");
				max = su-1;
			}else if(su<lotto) {  //엘즈 뒤에 이프를 넣어야함 안그럼 식이 하나 더들어감
				System.out.println(su+"보다 큰 수를 도전하세요");
				min = su+1;
			}
		}while(su!=lotto);
		System.out.println("콩크레이추레이션");
//		System.out.println(Math.random());//  <--0부터 1미만의 난수 실수 를 발생시키는 언어
//		System.out.println(Math.random()*45); // ()*10); <-0이상 10미만의 난수
//		System.out.println((int)(Math.random()*45)); // 0~44사이의 난수 정수
//		System.out.println((int)(Math.random()*45)+1); //1~45사이의 난수 정수
		scanner.close();
	}
}
