package com.lec.ex01_runnable;

public class TargetTestMain {
	public static void main(String[] args) {
		Target target = new Target(); //Runnable target = new Target();
		
		Thread t1 = new Thread(target, "A");// A��� �̸��� ������ ���� - target.run() �� ���� �ϴ� ������.
		Thread t2 = new Thread(target, "B"); //B��� �̸��� ������ ���� - target.run() �� �����ϴ� ������ .  ���� ���� Ÿ���̴�.
		
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main �Լ� ��.");
		
		
		
		
		
		
	}
}
