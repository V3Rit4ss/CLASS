package com.lec.ex;
//중복 메인함수 메소드로 뺌.
public class Ex02_beforOOP2 {
	//sum() method 위던 아래던 상관없음
	private static int sum(int to) { 
		int result = 0; //누적해서 전달할 변수
		for(int i=1 ; i<=to ; i++) {
			result = result +i ; //result += i
		}
		return result ; 
	}
	private static int sum(int from, int to) {  //첫 프롬 1 첫 투 10 //프라이빗은 접근제한자. 한곳에서만 쓰는
		int result = 0; //누적해서 전달할 변수
		for(int i=from ; i<=to ; i++) {
			result = result +i ; //result += i
		}
		return result ; //밑에있는 해당하는 sum 값이 리턴 때문에 바뀐다.
		//System.out.println("1"); //리턴밑에는 무엇을 추가를 못한다.
	}
	private static String evenOdd(int value) {
		String result = value%2==0 ? "짝수입니다." : "홀수입니다.";
		return result ;
	}
	public static void main(String[] args) { //변수이름과 함수이름 같아도 댐
		int sum =sum (10);     //<--- 변수이름과 함수이름 같아도 댐 자바에서는 함수와 변수와 다른개체.
		System.out.println("합은 "+sum);
		System.out.println(evenOdd(sum)); 
		sum = sum(1,100);
		System.out.println("합은 "+sum);
		System.out.println(evenOdd(sum)); 
		sum = sum(10,51);
		System.out.println("합은 "+sum);
		System.out.println(evenOdd(sum)); 		
	}//메인함수
	//sum() method
}//
