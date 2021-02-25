package com.lec.ex05_synchronize;  //���߿� �������� �ϴ¹� : ����ȭ �� �Ѵ�. synchronize
//������ N���� �۾���ü 1�� ����  - runnable�� �̿�
public class ThreadEx implements Runnable {
	private int num; //���� ���� ����
	@Override
	//synchronized run() �����߿��� �ƹ��� ��������.
	public void run() {
		for(int i =0; i<10; i++) {
			out();
			
				try {
					Thread.sleep(500);//0.5�� ���
				} catch (InterruptedException e) { }
		}//for
		
	}//run
	public synchronized void out() {
		String threadName = Thread.currentThread().getName();
		if(threadName.equals("A")) {
			System.out.println("~ ~ ~ A ������ ~ ~ ~");
			num++;
		}
		System.out.println(threadName+"�� num = "+num);
	}
}//class
