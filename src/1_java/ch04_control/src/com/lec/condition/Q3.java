package com.lec.condition;

import java.util.Scanner;

//  사용자로부터 가위(0) , 바위 (1) , 보 (2) 중 입력받고,
//  컴퓨터도 가위(0) , 바위 (1) , 보 (2) 중 하나를 선택해서 출력하기
public class Q3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위(0), 바위(1), 보(2) 중 하나를 선택 :");
		int you = scanner.nextInt();
		if(you==0) {
			System.out.println("가위를 내셨네");
		}else if (you==1) {
			System.out.println("바위를 내셨네");
		}else if(you==2) {
			System.out.println("보를 내셨네");
		}else {
			System.out.println("이눔!");
		}
		scanner.close();
		int computer = (int)(Math.random()*3);   //컴퓨터가 가지고있는 변수에서 랜덤으로 픽하는
		if(computer==0) {
			System.out.println("컴은 가위야");
		}else if(computer==1) {
			System.out.println("컴은 바위야");
		}else {
			System.out.println("컴은 보야");
		}
		if((you +2 )%3 == computer) {
			System.out.println("당신이 이겼다");
		}else if(you==computer) {
			System.out.println("비겼다");
		}else {
			System.out.println("컴퓨터가 이겼다");
		}
		//Math.random() 0부터 1보다 작은 실수 난수를 발생
		//System.out.println(Math.random()*3); //0 ~ 2.99999999999999 에서 넘어가지않는다 오라클이 그렇게함 ㅋ;
		//System.out.println( (int) (Math.random()*3));   컴퓨터보고 찾으라하면 딥러닝이다.
		if(you==0) {    //이쪽 부터 다시해야함
			if(computer==0) {
				System.out.println("비겼다");
			}else if(computer==1) {
				System.out.println("컴퓨터가 승리");
			}else {
				System.out.println("컴퓨터가 ");
			}
		}//you if문
	}//main 함수
}//class