package com.lec.ex04_threadNobjectN;

public class ThreadEx02TestMain {
	public static void main(String[] args) {
		//t1.run() 수행하는 쓰레드 A 생성 /t1.num
		Thread t1 = new ThreadEx02("A");  // ("A") 못함. 매개변수 있는 생성자를 만들어놓으면 안에 넣는거 가능.
		// t1.setName("A");   매개변수 생성자 안에 super 안쓰면. 왼쪽을 넣어야한다.
		Thread t2 = new ThreadEx02("B");  //t2.run() 수행하는 쓰레드 B /t2.num
		
		t1.start();
		t2.start();
	}
}
