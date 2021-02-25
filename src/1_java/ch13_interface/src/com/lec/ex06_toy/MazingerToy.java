package com.lec.ex06_toy;

public class MazingerToy implements IMissile, IMOverArmLeg {
	public MazingerToy() {
		System.out.println("마징가 장난감 입니다.");
		canMissile();
		canMoveArmLeg();
		System.out.println("--------------------------------");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("팔 다리를 움직일 수 있습니다.");
	}

	@Override
	public void canMissile() {
		System.out.println("미사일을 쏠 수 있습니다.");
	}
	@Override
	public String toString() {
		return "미사일 쏘며 팔 다리 움직이는 마징가 장난감.";
	}
	
}
