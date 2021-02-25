package com.lec.ex06_toy;

public class MazingerToy implements IMissile, IMOverArmLeg {
	public MazingerToy() {
		System.out.println("��¡�� �峭�� �Դϴ�.");
		canMissile();
		canMoveArmLeg();
		System.out.println("--------------------------------");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("�� �ٸ��� ������ �� �ֽ��ϴ�.");
	}

	@Override
	public void canMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}
	@Override
	public String toString() {
		return "�̻��� ��� �� �ٸ� �����̴� ��¡�� �峭��.";
	}
	
}
