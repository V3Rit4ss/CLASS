package com.lec.ex05_shape;

public abstract class Shape {
	public void draw() {
		System.out.println("도형을 그려요");
		
	}
	public abstract double computeArea(); //추상메소드 -->넓이를 리턴 하는 메소드로 바꿀거임.
}
