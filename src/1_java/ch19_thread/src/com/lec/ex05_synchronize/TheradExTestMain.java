package com.lec.ex05_synchronize;  //������N�� �� ���� 1��.

public class TheradExTestMain {
	public static void main(String[] args) {
		ThreadEx target = new ThreadEx(); // �۾� ��ü 1�� ������ ����
		Thread t1 = new Thread(target, "A");
		Thread t2 = new Thread(target, "B");
		
		t1.start();
		t2.start();
		System.out.println("main �Լ���.");
		//������ �����Ǳ⶧���� b�� num ���� �����ȴ�.
	}
}
//~ ~ ~ A ������ ~ ~ ~ ���� ����������.
//A�� num = 2