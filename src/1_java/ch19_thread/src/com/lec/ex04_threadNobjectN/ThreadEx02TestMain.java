package com.lec.ex04_threadNobjectN;

public class ThreadEx02TestMain {
	public static void main(String[] args) {
		//t1.run() �����ϴ� ������ A ���� /t1.num
		Thread t1 = new ThreadEx02("A");  // ("A") ����. �Ű����� �ִ� �����ڸ� ���������� �ȿ� �ִ°� ����.
		// t1.setName("A");   �Ű����� ������ �ȿ� super �Ⱦ���. ������ �־���Ѵ�.
		Thread t2 = new ThreadEx02("B");  //t2.run() �����ϴ� ������ B /t2.num
		
		t1.start();
		t2.start();
	}
}
