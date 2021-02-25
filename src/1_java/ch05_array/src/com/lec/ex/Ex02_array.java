package com.lec.ex;

public class Ex02_array {
	public static void main(String[] args) {
		//double[] hak = {4.5,3.3,3.0};   변수 주머니는 다양하게 사용할수있다.
		//String[] names = {"홍길동 , 김길동"};
		int i = 10;
		int j = i;
		j = 100;
		System.out.printf("i=%d, j=%d\n", i , j);
		int[] score = {10,20,30,40,50};//위아래. 이렇게 하면
		int[] s = score;   // 같은곳을 참조한다.
		s[0] = 100;
		for(int idx=0 ; idx<score.length ; idx++) {  //
			System.out.printf("score[%d] = %d, s[%d]=%d\n", idx, score[idx] , idx , s[idx]);  //배열 카피.
		}
	}
}
