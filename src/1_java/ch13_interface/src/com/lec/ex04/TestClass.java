package com.lec.ex04;
//i1 ,i2 ,i3  //i3 �� ����(implements)��.
public class TestClass implements I3 { // �����Լ��� �ƴ϶� ���� �Ұ�.

	@Override
	public void m1() {
		System.out.println("��� i1 : "+i1);
	}

	@Override
	public void m2() {
		System.out.println("��� i2 : "+i2);
	}

	@Override
	public void m3() {
		System.out.println("��� i3 : "+i3);
	}

}
