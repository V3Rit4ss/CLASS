package com.lec.ex05_scanner;

import java.util.Scanner;

//cf. next() -> nextLine()���� �����. ->nextLine()�̿�
//1. nextLine() �̿� -> 2. next() �̿�
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ּҸ� �Է��ϼ���");
		String address = sc.nextLine();
		System.out.println("�Է��Ͻ� �ּҴ� : "+address);
		System.out.print("�̸��� �Է��ϼ���");
		String name = sc.nextLine(); //�����̽� ����
		System.out.println("�Է��Ͻ� �̸��� : "+name);
		System.out.print("���̸� �Է��ϼ���");
		int age = sc.nextInt();
		System.out.println("�Է��Ͻ� ���̴� : "+age);
	}
}
