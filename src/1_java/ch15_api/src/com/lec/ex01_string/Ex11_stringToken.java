package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex11_stringToken {
	public static void main(String[] args) {
		String str1 = "정해인 유준상 강동원 김윤석 하정우";
		String str2 = "2020/12/14";
		// space , \t , \n 단위로 token 나눔
		StringTokenizer  token1 = new StringTokenizer(str1); //맨처음 아이를 가르키고 뿌리고 하나 증가해서 다음거. 그런다음 끝에 도달해서 끝.
		StringTokenizer token2 = new StringTokenizer(str2,"/");
		System.out.println("token1 의 갯수 : "+token1.countTokens());
		while(token1.hasMoreTokens()) { //1번 가르키고 뿌린다음 넥스트 토큰 이 있냐 하고 있으면 가르킨거 뿌리고. 반복.
			System.out.println(token1.nextToken());
		}
		
		System.out.println("token2 의 갯수 : "+token2.countTokens());
		while(token2.hasMoreElements()) {
			System.out.println(token2.nextToken());
		}
	}
}
