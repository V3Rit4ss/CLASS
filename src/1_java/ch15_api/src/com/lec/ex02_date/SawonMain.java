package com.lec.ex02_date;

public class SawonMain {
	public static void main(String[] args) {
		Sawon s1 = new Sawon("a01","ȫ�浿","IT");//���� ,���� �Ի��� ��� (����) = new Date();
		Sawon s2 = new Sawon("a01","����","IT",2020,12,10);
		
		System.out.println(s1);
		System.out.println(s2);
	}
}
