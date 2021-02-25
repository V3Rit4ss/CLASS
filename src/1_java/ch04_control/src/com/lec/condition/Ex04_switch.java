package com.lec.condition;

public class Ex04_switch {
	public static void main(String[] args) {
		int num =2;
		switch(num) {
		case 1:
			System.out.println("주사위 1"); break; // 브레이크가 있어야 걸리는곳에서 연산이 끝. '스위치문을 할때는 브레이크를 까먹지 말것.'
		case 2:
			System.out.println("주사위 2"); break;
		case 3:
			System.out.println("주사위 3"); break;
		default:
			System.out.println("그 외"); break;
		}
	}
}
