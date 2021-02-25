package com.lec.ex07_super;

public class ChildClass extends ParentClass {
	private String cStr = "자식 클래스";

	public ChildClass() {
		System.out.println("자식 생성자");
	}

	@Override
	public void getMamiName() {
		//this. ; 내 객체의
		//this() ; 현 클래스의 생성자 함수
		//super. ; 부모의  , 약간만 바꿀때. (아무때나 써도 댐.)
		//super() ; 부모 클래스의 생성자 (맨 윗줄에서만 쓰임).위치적인 제한이 있음.
		System.out.print("이쁜 아주 이쁜 ");
		super.getMamiName(); 
	}

	public String getcStr() {
		return cStr;
	}

	public void setcStr(String cStr) {
		this.cStr = cStr;
	}
}
