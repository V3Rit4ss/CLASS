package com.lec.ex02_thread;

public class TargetExTestMain {
	public static void main(String[] args) {
		//Target01 �̶�� ������ ���� - target01.run() �� ����
		Thread target01 = new TargetEx01();// = TargetEx01 target01 = new TargetEx01();
		target01.setName("A"); // ������ �̸� �� ������.
		//Target02 ��� ������ ���� - target02.run() �� ���� ���� �ٸ� ������ �۾��� ����.
		Thread target02 = new TargetEx02();
		target02.setName("B");
		target01.start();  //01�� ���� ���� 02�� ���� ���� ��.
		target02.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("���� main �Լ�");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}//for
		
		
	}//main
}//class
