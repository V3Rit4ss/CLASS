package com.lec.ex4_accessTest;

import com.lec.ex3_accessTest.AccessTest;

public class Main {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		//System.out.println(obj.defaultMember); //다른 패키지
		//System.out.println(obj.protectedMember);//다른
		System.out.println(obj.publicMember);
		//obj.defaulMethod();
		//obj.protectedMember
		obj.publicMethod();
	}
}
