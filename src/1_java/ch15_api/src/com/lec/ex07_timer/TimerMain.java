package com.lec.ex07_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(); //true �ִ����� : ���α׷� ����Ǹ� timer ����
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000); // 2���ĺ��� 2�ʸ���
		timer.schedule(task2, 500, 1000); //0.5�� �ĺ��� 1�ʸ��� ����
		Thread.sleep(10000); //10�� ���. //������ ������������ �ߴ°���.
		System.out.println("��");
		
		
		
	}
}
