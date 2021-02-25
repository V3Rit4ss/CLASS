package com.lec.ex;
// 관계(비교)연산자 : 같다(==) , 다르다 (!=) , 크다(>) , 작다 (<) ,크거나 같다 (>=)
public class Ex_03 {
	public static void main(String[] args) {
		int n1=10, n2=5;
		boolean result = n1 > n2;  // n1 n2 연산후 리절트 값에 들어감  [ () 우선순위 = 첫번째 ]
		System.out.printf("%d %s %d = %b\n" , n1, ">", n2, result); // %s : > 기호
		result = (n1 >= n2); // () 1순위
		System.out.printf("%d %s %d = %b\n" , n1, ">=", n2, result);
		result = n1 == n2;
		System.out.printf("%d %s %d = %b\n" , n1, "==", n2, result);
		result = n1 != n2;
		System.out.printf("%d %s %d = %b\n" , n1, "!=", n2, result);
	}
}
