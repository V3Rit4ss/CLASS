package com.lec.ex13_final;
/*
 * 20 / 12 - 08 Won Dong Seon
 */
public class Animal {
	protected int speed;
	public void running() {
		//final int TEMP = 10;
		//TEMP += 5;
		speed += 5;
		System.out.println("뛰고 있어요. 현재속도 : "+speed);
	}
	public final void stop() { //상속불가 오버라이드 하지마~
		speed = 0;
		System.out.println("멈춤");
	}
}
