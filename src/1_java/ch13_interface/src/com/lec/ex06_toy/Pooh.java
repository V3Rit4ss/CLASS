package com.lec.ex06_toy;

public class Pooh implements IMOverArmLeg {
	public Pooh() {
		System.out.println("������ Ǫ �Դϴ�.");
		canMoveArmLeg();
		System.out.println("------------------------------");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("�� �ٸ��� ������ �� �ֽ��ϴ�.");
	}
	@Override //tostring �������̵�
	public String toString() {
		
		return "�� �ٸ� �����̴� ������ Ǫ";
	}
}
