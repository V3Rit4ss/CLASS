package com.lec.ex03_threadN_object1;  //쓰레드N개 의 공유 1개.

public class TheradExTestMain {
	public static void main(String[] args) {
		ThreadEx target = new ThreadEx(); // 작업 객체 1개 쓰레드 공유
		Thread t1 = new Thread(target, "A");
		Thread t2 = new Thread(target, "B");
		
		t1.start();
		t2.start();
		System.out.println("main 함수끝.");
		//변수가 공유되기때문에 b의 num 값도 공유된다.
	}
}
