package com.lec.ex05_shape;

public class TestMain {

	public static void main(String[] args) {
//		Shape shape1 = new Circle(5);
//		Shape shape2 = new Rectangle(10,5);
//		Shape shape3 = new Triangle (5,10);
		Shape[] shape = { new Circle(5), new Rectangle(10,5), new Triangle(5,10)};
//		for(int i=0 ; i<=shape.length ; i ++) {
//			shape[i].draw();
//			shape[i].computeArea();  //실행 단계 에러 : 예외 발생.  실행단계 에러 란 = 빨간 밑줄도 없이 깨끗한 상태인데도 불구하고 실행시켰을시 에러뜨는것.
//		}
		for(Shape s : shape) { //확장 for문
			s.draw();
			System.out.println("도형의 넓이는 "+s.computeArea());
		}

	}

}
