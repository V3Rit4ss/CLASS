package com.lec.ex06_toy;

public class AirplaneToy implements IMissile, ILight {
	public AirplaneToy() {
		System.out.println("����� �峭�� �Դϴ�.");
		canLight();
		canMissile();
	}
	@Override
	public void canLight() {
		System.out.println("�Һ� �߻� �����մϴ�.");
	}

	@Override
	public void canMissile() {
		System.out.println("�̻��� �� �� �ֽ��ϴ�.");
	}
	@Override
	public String toString() {//super.toString() ������Ʈ�� �ִ°� ���� ��Ű�� ����.
		return "�Һ��� �̻��� ��� �����.";
	}
	
}
