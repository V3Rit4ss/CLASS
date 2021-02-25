package com.lec.loop;

public class Ex04_for {
	public static void main(String[] args) {
		for(int i=15; i<=50; i++) {
			System.out.print(i+"\t");
			if(i%5 == 4) {
				System.out.println();
			}//if
		}//for
	}
}
