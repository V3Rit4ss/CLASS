package com.lec.ex;
// 메소드 를 모아놓을수있다. 패키지도 모을수있음
public class Arithmetic {
	public int sum(int to) { //스태틱이 없다? 설계도면.
		int result = 0; //누적해서 전달할 변수
		for(int i=1 ; i<=to ; i++) {
			result = result +i ; //result += i
		}
		return result ; 
	}
	public int sum(int from, int to) {  //첫 프롬 1 첫 투 10 //프라이빗은 접근제한자. 한곳에서만 쓰는
		int result = 0; //누적해서 전달할 변수
		for(int i=from ; i<=to ; i++) {
			result = result +i ; //result += i
		}
		return result ; //밑에있는 해당하는 sum 값이 리턴 때문에 바뀐다.
		//System.out.println("1"); //리턴밑에는 무엇을 추가를 못한다.   //한개의 리턴값만 간다 .
	}
	public String evenOdd(int value) {
		String result = value%2==0 ? "짝수입니다." : "홀수입니다.";
		return result ;
	}
	public static int abs(int value) {
		int result = (value>=0 ) ? value : -value;
//		if(value <=0 ) {
//			reslut = value;
//		}else {
//			reslut = -value;
//		}
		return result;
	}
}
