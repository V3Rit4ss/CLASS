package com.lec.ex06_wrapper;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		if(i==j) {
			System.out.println("i�� j�� ����.");
		}//obj �� ��ü�̴�.
		Integer obj1 = new Integer(10); //����. //���ʵ����Ͱ�  ������Ʈ�� ������ ��ü�����ͷ� �ٲ��.
		Integer obj2 = new Integer(10);
		if("Hello".equals(i)) { //������ �ȿ� i �� 10�� ����.
			System.out.println("����");
		}else {
			System.out.println("�����ʴ�.");
		}
		if(obj1.equals(obj2)) {
			System.out.println("obj1�� obj2 �� �����ʹ� ����.");
		}
	//	int total = obj1.intValue() + obj2.intValue();  //������ �̷��� �ؾ���.
		int total = obj1 +obj2;  //�̰��� ����.
	}
}
