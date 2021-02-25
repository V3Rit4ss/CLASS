package com.lec.ex01_parentcild; //만듦 순서2.
//상속 받는 클래스 : Child class , 자손 클래스
public class ChildClass extends ParentClass {//상속 해준 클래스
	String cStr = "아들클래스";
	public ChildClass() {
		System.out.println("자식 클래스 객체 부분 생성");
	}
}
