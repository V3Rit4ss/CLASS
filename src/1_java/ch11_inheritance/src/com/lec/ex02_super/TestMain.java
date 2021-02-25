package com.lec.ex02_super;

public class TestMain {
	public static void main(String[] args) {
//		Child child = new Child();
//		System.out.println("i값: "+child.getI());
//		System.out.println("j값: "+child.getJ());
//		child.setI(10); child.setJ(20);
		Child child =new Child(10,20); //매개변수 있게 할때.
		System.out.println("i값: "+child.getI());
		System.out.println("j값: "+child.getJ());
		child.sum();
	}
}
