package com.lec.ex04_Object;

public class Ex01_Person {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = new String("java");
		if(str1.equals(str2)) {
			System.out.println("str1 �� str2 �� ���� ���ڿ��̴�");
		}else {
			System.out.println("str1 �� str2 �� �ٸ� ���ڿ��̴�.");
		}
		Person p1 = new Person(9201211234560L); //L �������� �ٲ� ����.
		Person p2 = new Person(9201211234560L);
		if(p1.equals(p2)) {  
			System.out.println("���� ��ü��");
		}else {
			System.out.println("�ٸ� ��ü��.");
		}
	}
}
