package com.lec.ex01_interface;
// �� Ŭ������ �ϳ��� ���. �������̽��� �ΰ� �̻� ���� ��� ����. : implements (����.)
public class InterfaceClass implements Interface_Ex01, Interface_Ex02 {

	@Override//ex01 �������̵�
	public void method1() {
		System.out.println("���� ������ implements �� Ŭ�������� �ؿ�.");
		
	}

	@Override//ex02 �������̵�
	public String method2() {
		System.out.println("���� ������ implements �� Ŭ�������� �ؿ�.");
		return null; //��Ʈ�� ���� ������ ��Ʈ�� �ƴϸ� �⺻�� null�� �ص� ��.
	}

}
