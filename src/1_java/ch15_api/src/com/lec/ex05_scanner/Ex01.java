package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt(); 
		System.out.println("�Է��Ͻ� ���̴� : "+age);
		System.out.print("�̸��� �Է� �ϼ��� : ");
		String name = sc.next();  // ���۾�   1. \n ������ ��.     2.ȫ�浿(����.)\n 1�� ���۵����� �������� 2�������Ͱ� ��.
		System.out.println("�Է��Ͻ� �̸��� : "+name);  //��� ���ⰰ����� �״��������� �غ����� ���¿��� ��ĳ�� ����.
		// ���ۿ� ó�� ������ \n�� �����ϰ� whiteSpece ������ ������
		
		System.out.print("�ּҸ� �Է��ϼ��� ");
		sc.nextLine();  //���� �����ִ� . (\n ������)
		String address = sc.nextLine(); // ���ۿ� \n�� ������ �ձ��� ����.
		System.out.println("�Է��Ͻ� �ּҴ� "+address);
		System.out.println("====================���α׷� ��.===================");
		
		
		
	}
}
