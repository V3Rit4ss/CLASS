package com.lec.loop;

public class Ex03_for {
	public static void main(String[] args) {
		for(int i=1 ; i<=5 ; i++) {
			for(int j=1 ; j<= i ; j++) {
				System.out.print('*');
			}
			System.out.println();//개행 해라
		}
//		for(int i=1 ; i<=5; i++) {
//			System.out.print('*');
//		}
	}
}
