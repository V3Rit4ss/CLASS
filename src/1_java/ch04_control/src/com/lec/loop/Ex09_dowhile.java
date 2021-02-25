package com.lec.loop;

import java.util.Scanner;

public class Ex09_dowhile {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int num;
		do {
			System.out.print("짝수를 입력하세요 : ");
			num = scanner.nextInt(); // 사용자로부터 입력받은 수를 num 할당  //블록안에 선언 하면 블록안에서 나올때 사라진다 유의하자
		}while(num%2 == 1 || num%2== -1);/*num이 홀수냐*/ //||연산자는 둘중에 하나 맞는지 아닌지 확인함 연산자 파트가서 참고 바람.
		System.out.println("입력하신 짝수는"+num);
		scanner.close();
	}
}
