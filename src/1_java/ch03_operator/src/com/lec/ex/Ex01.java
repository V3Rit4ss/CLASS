package com.lec.ex;
//산술 연산자 ( + , - , * , / , [%나머지연산자])
public class Ex01 { // class 시작
	public static void main(String[] args) { //main 함수 시작
		int n1 = 33, n2=10;
		int result;
		double resultDouble; //리절트 더하기 더블 선언방법
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n" , n1, '+' , n2, result);
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n" , n1, '-' , n2, result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n" , n1, '*' , n2, result);
		result = n1 / n2;
		System.out.printf("%d %c %d = %d\n" , n1, '/' , n2, result);
		resultDouble = (double)n1 / n2;
		System.out.printf("%d %c %d = %.1f\n" , n1, '/' , n2, resultDouble); //%.1f\n 소수점 한자리 표시 , %.3f\n 소수점 세자리 표시.
		result = n1 % 2;
		System.out.printf("%d %c %d = %d\n" , n1, '%' , n2, result);
		// 나머지 연산자의 쓰임새
		if (n1%2==0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
	} //main 함수 끝
}//class 끝d
