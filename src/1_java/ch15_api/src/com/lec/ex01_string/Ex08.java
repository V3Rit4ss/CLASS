package com.lec.ex01_string;
//��Ƽ���� ����. 100�� �̻��� ��ü ������ �ϸ� ������ �����Ͱ� �þ�鼭 ����ȭ�� �ɸ��鼭 �ӵ��� ������.
public class Ex08 {
	public static void main(String[] args) {
		String str1 = "������";   //  -> �̷��� �ϴ°� ����ó��.  String str1 = new String ("������")
		String str2 = "������";
		if(str1 == str2) {
			System.out.println("str1 �� str2 �� ���� ��ü ����");
		}else {
			System.out.println("str1 �� str2 �� �ٸ� ��ü ����");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		str1 = str1 + "2002";  // �̷��� �ϵ� ������ �ϵ� ����.  str1 = str1.concat("2002");
		if(str1 == str2) {
			System.out.println("str1 �� str2 �� ���� ��ü ����");
		}else {
			System.out.println("str1 �� str2 �� �ٸ� ��ü ����");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}
