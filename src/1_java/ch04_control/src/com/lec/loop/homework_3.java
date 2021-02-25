package com.lec.loop;

import java.util.Scanner;

public class homework_3 {
	public static void main(String[] args) {
		int ai, you;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("가위(0), 바위(1), 보(2) 중 하나를 내시오. 원하지 않을시엔 -1) : ");
			you = sc.nextInt();
			if(you== -1) {
				break;
			}
			ai = (int)(Math.random()*3);
			if(you > 2 || you < -1) {
				System.out.println("가위(0), 바위(1), 보(2) 보기 중에서 만 선택 하시오.");
			}else if((you+2)%3==ai) {
				System.out.println("입력 값 "+(you==0? "가위":you==1? "바위" : "보"));
				System.out.println("AI 는"+(ai==0? "가위":ai==1? "바위":"보"));
				System.out.println(" 당신이 이겼습니다. ");
			}else if(you == ai){
				System.out.println("입력 값 "+(you==0?"가위":you==1? "바위":"보"));
				System.out.println("AI 는"+(ai==0? "가위":ai==1?"바위":"보"));
				System.out.println(" AI 와 생각이 같았습니다. ");
			}else {
				System.out.println("입력 값 "+(you==0?"가위":you==1? "바위":"보"));
				System.out.println("AI 는"+(ai==0? "가위":ai==1?"바위":"보"));
				System.out.println(" 당신은 졌습니다. ");
			}//if
		} sc.close();
		System.out.println("See U next time");
	}//main
}//class
