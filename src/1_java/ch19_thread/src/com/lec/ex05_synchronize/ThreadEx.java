package com.lec.ex05_synchronize;  //도중에 못끼어들게 하는법 : 동기화 를 한다. synchronize
//쓰레드 N개가 작업객체 1를 공유  - runnable을 이용
public class ThreadEx implements Runnable {
	private int num; //공유 변수 선언
	@Override
	//synchronized run() 수행중에는 아무도 못끼어든다.
	public void run() {
		for(int i =0; i<10; i++) {
			out();
			
				try {
					Thread.sleep(500);//0.5초 대기
				} catch (InterruptedException e) { }
		}//for
		
	}//run
	public synchronized void out() {
		String threadName = Thread.currentThread().getName();
		if(threadName.equals("A")) {
			System.out.println("~ ~ ~ A 수행중 ~ ~ ~");
			num++;
		}
		System.out.println(threadName+"의 num = "+num);
	}
}//class
