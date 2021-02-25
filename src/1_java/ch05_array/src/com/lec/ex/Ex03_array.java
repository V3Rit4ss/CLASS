package com.lec.ex;
// 배열의 복사
public class Ex03_array {
	public static void main(String[] args) { //String[] = 
		int[] score = {10,20,30,40,50};
		int[] s= new int[score.length]; //일반 for문
//		for(int i=0; i<score.length ; i++) {
//			s[i] = score[i];   //전혀 다른공간에 서로 같은 데이터내용.
//		}
		System.arraycopy(score, 0, s, 0, score.length); //api 중 하나 궁금하면 커서로 가져다데고 박스클릭하고 번역기 ㄱㄱ
		s[0] = 999;
		for(int i=0; i<s.length ; i++) {
			System.out.printf("s[%d]=%d, score[%d]=%d\n" , i, s[i], i, score[i]); //배열을 복사
		}
	}
}
