package com.lec.ex01_runnable;

public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable target01 = new TargetEx01();  // ���� ����. TargetEx01 target01 = new TargetEx01();
		Runnable target02 = new TargetEx02();  // �� ���װ� �Ʒ����װ� ����.
		Thread threadA = new Thread(target01, "A");  // ,"A" ��� �̸��� �൵ ���൵ �����. A ��� �̸��� ������ ���� - target01.run() �� �����ϴ� ������.
		Thread threadB = new Thread(target02, "B");  // ���� ����� ����. ���� �ٸ� ����.
		threadA.start();  //���� ���� ���� ��������� �𸥴�.
		threadB.start();  // ���డ���� ����.
		for(int i =0; i<10 ; i++) {
			System.out.println("���� main ������"+Thread.currentThread().getName()); //���� �����ϴ� �������� �̸�
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}//for
	}//main
}//class
