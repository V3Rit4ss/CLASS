package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex12_tokenArray {
	public static void main(String[] args) {
		//str�� tokenizer �Ͽ� names �迭�� 
		String str = "������ ���ػ� ������ ������ ������";
		String[] name;
		//�����̽� \t \n  => whiteSpace
		StringTokenizer token = new StringTokenizer(str);
		name = new String[token.countTokens()];
		int idx = 0;
		System.out.println("token ���� : "+token.countTokens());
		while(token.hasMoreElements()) {
			name[idx++] = token.nextToken();
		}
		System.out.println("����� �迭�� ������ Ȯ��.");
		for(String name1 : name) {
			System.out.println(name1);
		}
	}
}
