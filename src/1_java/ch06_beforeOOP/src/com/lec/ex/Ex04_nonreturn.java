package com.lec.ex;
//리턴도 메소드도 없는 스태틱
public class Ex04_nonreturn {
	public static void main(String[] args) {
		printCh();
		System.out.println("Hello, World!");
		printCh('=');
		System.out.println("Hello, Java!");
		printCh('-' , 30);
	}
	private static void printCh(char ch , int count) {
		for(int cnt=1 ; cnt<=count ; cnt++) {
			System.out.print(ch);
		}
		System.out.println();
	}
	private static void printCh(char ch) {
		for(int cnt=1; cnt<=20; cnt++) {
			System.out.print(ch); //ch가 20개 있는 라인
		}
		System.out.println();//개행
	}
	private static void printCh() {
		for(int cnt =1 ; cnt<=20; cnt++) {
			System.out.print('*'); // *가 20개 있는 라인
		}
		System.out.println();
	}
}
