package com.lec.ex04_threadNobjectN;

public class ThreadEx implements Runnable {
	private int num; // 공유 변수 선언

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			String threadName = Thread.currentThread().getName();
			if (threadName.equals("A")) {
				System.out.println("~ ~ ~ A 수행중 ~ ~ ~");
				num++;
			}
			System.out.println(threadName + "의 num = " + num);
			try {
				Thread.sleep(500);// 0.5초 대기
			} catch (InterruptedException e) {
			}
		} // for

	}
}
