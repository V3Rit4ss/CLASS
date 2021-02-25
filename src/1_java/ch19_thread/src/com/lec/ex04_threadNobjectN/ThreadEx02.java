package com.lec.ex04_threadNobjectN;

public class ThreadEx02 extends Thread { //쓰레드 로 부터 상속받은.
	private int num; // 공유 변수 선언
	
	public ThreadEx02() {  //매개변수 없는 생성자.
		super();
	}
	public ThreadEx02(String name) { //매개변수있는 생성자.
		super(name);    //setName(name);
	}
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
