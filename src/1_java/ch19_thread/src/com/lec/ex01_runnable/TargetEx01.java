package com.lec.ex01_runnable;

public class TargetEx01 implements Runnable {

	@Override
	public void run() {//���ÿ� �ϰ������ �����ϴ°�
		for(int i = 0; i<10; i++) {
			System.out.println("�ȳ��ϼ���."+i);
			try {
				Thread.sleep(500);//0.5�� ���� ������
			} catch (InterruptedException e) {
				
				
			} 
		}
		
	}

}
