package com.lec.ex04_Object;

public class RectanleMain {
	public static void main(String[] args) {
		Rectanle r = new Rectanle();
		System.out.println(r);
		Rectanle r1 = new Rectanle(10,5,"���̿÷�");
		Rectanle r2 = new Rectanle(4,7,"����");
		Rectanle r3 = new Rectanle(20,10,"��Ʋ��ƽ ���");
		Rectanle r4 = new Rectanle(4,7,"����");
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r.equals(r1));
		System.out.println(r2.equals(r4));
	}
}
