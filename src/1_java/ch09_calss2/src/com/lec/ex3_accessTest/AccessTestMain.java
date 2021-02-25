package com.lec.ex3_accessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember);
		System.out.println(obj.defaulrMember); //같은 패키지
		System.out.println(obj.protectedMember);//같은 패키지거나 상속 받은 클래스라서
		System.out.println(obj.publicMember);//같은 패키지
		//obj.privateMethod();
		obj.defaultMethod();
		obj.protectedMethod();
		obj.publicMethod();
	}
}
