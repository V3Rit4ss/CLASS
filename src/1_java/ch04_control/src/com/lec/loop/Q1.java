package com.lec.loop;

public class Q1 {
	public static void main(String[] args) {
		int result = 1;
		for(int i = 1; i <= 10; i++) {
			result *= i; // result = result*1
		}
		System.out.println("1~10±îÁöÀÇ °öÀº " + result);
	}
}