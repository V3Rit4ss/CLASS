package com.lec.ex01_runnable;

public class TargetTestMain {
	public static void main(String[] args) {
		Target target = new Target(); //Runnable target = new Target();
		
		Thread t1 = new Thread(target, "A");// A라는 이름의 쓰레드 생성 - target.run() 을 수행 하는 쓰레드.
		Thread t2 = new Thread(target, "B"); //B라는 이름의 쓰레드 생성 - target.run() 을 수행하는 쓰레드 .  서로 같은 타켓이다.
		
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main 함수 끝.");
		
		
		
		
		
		
	}
}
