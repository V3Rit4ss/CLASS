package com.lec.ex01_parentcild; //¸¸µê ¼ø¼­3.

public class TestMain {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		child.getPapaName();
		child.getMamiName();
		System.out.println(child.pStr);
		System.out.println(child.cStr);
	}
}
