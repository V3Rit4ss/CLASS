package com.lec.ex04_threadNobjectN;

public class ThreadEx02 extends Thread { //������ �� ���� ��ӹ���.
	private int num; // ���� ���� ����
	
	public ThreadEx02() {  //�Ű����� ���� ������.
		super();
	}
	public ThreadEx02(String name) { //�Ű������ִ� ������.
		super(name);    //setName(name);
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			String threadName = Thread.currentThread().getName();
			if (threadName.equals("A")) {
				System.out.println("~ ~ ~ A ������ ~ ~ ~");
				num++;
			}
			System.out.println(threadName + "�� num = " + num);
			try {
				Thread.sleep(500);// 0.5�� ���
			} catch (InterruptedException e) {
			}
		} // for

	}
}
