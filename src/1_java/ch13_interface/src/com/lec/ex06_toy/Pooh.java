package com.lec.ex06_toy;

public class Pooh implements IMOverArmLeg {
	public Pooh() {
		System.out.println("곰돌이 푸 입니다.");
		canMoveArmLeg();
		System.out.println("------------------------------");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("팔 다리를 움직일 수 있습니다.");
	}
	@Override //tostring 오버라이드
	public String toString() {
		
		return "팔 다리 움직이는 곰돌이 푸";
	}
}
