package com.lec.loop;

public class Ex05_forbreak {
	public static void main(String[] args) {
		for(int i=1 ; i<11 ; i++ ) {
			if(i==5) {
				//break; // 반복문 블럭을 빠져나가버림 즉 실행이 끝나게함.
				continue; // 증감식으로 올라가  아래 조건식안가고 위로 바로 올라감.if 조건식에 맞는애는 건너뛰어버림  
			}
			System.out.print(i+ " ");
		}
	}
}
