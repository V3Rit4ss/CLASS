package com.lec.ex06_toy;

public class TestMain {
	public static void main(String[] args) {
		IToy[] toy = {new Pooh(), new MazingerToy(), new AirplaneToy()};
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(IToy t : toy) {         //확장for문
			System.out.println(t.getClass().getName()); //t 객체의 클래스 이름출력
			System.out.println(t); //t.toString()호출
			System.out.println("===============================");
		}
	}
}	
