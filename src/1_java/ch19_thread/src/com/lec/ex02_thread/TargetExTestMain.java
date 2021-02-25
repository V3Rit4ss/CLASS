package com.lec.ex02_thread;

public class TargetExTestMain {
	public static void main(String[] args) {
		//Target01 이라는 쓰레드 생성 - target01.run() 을 수행
		Thread target01 = new TargetEx01();// = TargetEx01 target01 = new TargetEx01();
		target01.setName("A"); // 쓰레드 이름 을 셋팅함.
		//Target02 라는 쓰레드 생성 - target02.run() 을 수행 서로 다른 내용의 작업을 수행.
		Thread target02 = new TargetEx02();
		target02.setName("B");
		target01.start();  //01을 먼저 할지 02를 먼저 할지 모름.
		target02.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("나는 main 함수");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}//for
		
		
	}//main
}//class
