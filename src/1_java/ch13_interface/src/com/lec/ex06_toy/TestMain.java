package com.lec.ex06_toy;

public class TestMain {
	public static void main(String[] args) {
		IToy[] toy = {new Pooh(), new MazingerToy(), new AirplaneToy()};
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(IToy t : toy) {         //Ȯ��for��
			System.out.println(t.getClass().getName()); //t ��ü�� Ŭ���� �̸����
			System.out.println(t); //t.toString()ȣ��
			System.out.println("===============================");
		}
	}
}	
