package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex11_stringToken {
	public static void main(String[] args) {
		String str1 = "������ ���ػ� ������ ������ ������";
		String str2 = "2020/12/14";
		// space , \t , \n ������ token ����
		StringTokenizer  token1 = new StringTokenizer(str1); //��ó�� ���̸� ����Ű�� �Ѹ��� �ϳ� �����ؼ� ������. �׷����� ���� �����ؼ� ��.
		StringTokenizer token2 = new StringTokenizer(str2,"/");
		System.out.println("token1 �� ���� : "+token1.countTokens());
		while(token1.hasMoreTokens()) { //1�� ����Ű�� �Ѹ����� �ؽ�Ʈ ��ū �� �ֳ� �ϰ� ������ ����Ų�� �Ѹ���. �ݺ�.
			System.out.println(token1.nextToken());
		}
		
		System.out.println("token2 �� ���� : "+token2.countTokens());
		while(token2.hasMoreElements()) {
			System.out.println(token2.nextToken());
		}
	}
}
