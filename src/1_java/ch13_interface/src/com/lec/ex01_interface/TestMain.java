package com.lec.ex01_interface;
//InterfaceEx1 InterfaceEx2
//interfaceClass
public class TestMain {  //�������̽�Ŭ���� ��� �Ʒ� ��ü�� ����ü�� �������� ������, ����üex1 �� ex2 �� ��ü�� ������ ����.
	public static void main(String[] args) { //��, '�ΰ�(ex3) = ������(ex2)'.  '����(ex1),������(ex2) �� �ΰ�(ex3) �̴�' ��� �Ұ� �ΰ�ó��.
		//Interface_Ex01 ex01 = new Interface_Ex01(); �Ұ�
		//Interface_Ex02 ex02 = new Interface_Ex02(); �Ұ�
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		
		Interface_Ex01 obj2 = new InterfaceClass();//1
		obj2.method1();
		//obj2.me2thod2(); �Ұ� �������̽�ex1 ���� �޼ҵ�2�� ����.    
		
		// 1�� 2�� ������� ������ �ٸ����� �ϴ°��� ������ �̶� �Ѵ�.
		
		Interface_Ex02 obj3 = new InterfaceClass();//2
		if(obj3 instanceof InterfaceClass) { //obj3 �� �������̽�Ŭ������ �ֳ� ��� ����� ����ȯ �ϴ°� ����.
		((InterfaceClass)obj3).method1(); // ((InterfaceClass)obj3) ����� ����ȯ. �Ժη� �ϴ°� ����.
		}
	//	obj3.method1(); �Ұ�.
		obj3.method2();
		
		// ������  : �Լ� ������   = �����ε�, �������̵�
//			    : ���� ������   = 
	}
}
