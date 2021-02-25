package com.lec.ex04_threadNobjectN;  // 쓰레드N개 의 공유N개

public class ThreadExTestMain {
	public static void main(String[] args) {
		Runnable target1 = new ThreadEx();//target1.num
		Runnable target2 = new ThreadEx();//target2.num
		Thread t1 = new Thread(target1, "A");
		Thread t2 = new Thread(target2, "B");
		
		t1.start();
		t2.start();
	}
}
