package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex12_tokenArray {
	public static void main(String[] args) {
		//str을 tokenizer 하여 names 배열로 
		String str = "정해인 유준상 강동원 김윤석 하정우";
		String[] name;
		//스페이스 \t \n  => whiteSpace
		StringTokenizer token = new StringTokenizer(str);
		name = new String[token.countTokens()];
		int idx = 0;
		System.out.println("token 갯수 : "+token.countTokens());
		while(token.hasMoreElements()) {
			name[idx++] = token.nextToken();
		}
		System.out.println("제대로 배열에 들어갔는지 확인.");
		for(String name1 : name) {
			System.out.println(name1);
		}
	}
}
