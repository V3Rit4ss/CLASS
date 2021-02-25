package com.lec.ex;
// 비트연산자 : &  ,  |      [&& || 트루나 풜스 둘중에 하나만 온다.]  0 풜스 1 트루  00001 : 1  00000: 0 00010 : 2 00011 : 3 
public class Ex_07 {
	public static void main(String[] args) {
		int n1 = 10;       // 0 ~ 01010 : 10  
		int n2 = 5;       //  0 ~ 00101 
		int result = n1 & n2; // 0 ~ 00000
		System.out.printf("%d %c %d = %d\n", n1, '&', n2, result);
		result = n1 | n2;  // 0 ~ 00111  (15)
		System.out.printf("%d %c %d = %d\n", n1, '|', n2, result);
	}
}
