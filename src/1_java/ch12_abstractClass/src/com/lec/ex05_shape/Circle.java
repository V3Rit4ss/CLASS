package com.lec.ex05_shape;

public class Circle extends Shape {
	private int r;  // r 반지름
	public Circle() {}
	public Circle(int r) {
		this.r = r;
	}
	@Override
	public double computeArea() {
		//System.out.println("원의 넓이는"+ (3.14*r*r)  );
		return 3.14*r*r;
	}
	@Override
	public void draw() {
		System.out.print("원 ");
		super.draw();
	}
	public int getR() {  //겟터 셋터 안쓸꺼면 안넣어도 댐.
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	
}
