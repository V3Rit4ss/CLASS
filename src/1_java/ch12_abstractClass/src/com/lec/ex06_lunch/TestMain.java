package com.lec.ex06_lunch;

import com.lec.cons.PriceTable;

public class TestMain {
	public static void main(String[] args) {
		Child1 c1 = new Child1(PriceTable.RICE , PriceTable.BULGOGI , PriceTable.SOUP , PriceTable.BANANA , PriceTable.MILK , PriceTable.ALMOND);   //����� ��Ƶ� ������ �����ظ��
		Child2 c2 = new Child2(PriceTable.RICE , PriceTable.BULGOGI , PriceTable.SOUP , PriceTable.BANANA , PriceTable.MILK , PriceTable.ALMOND); //PriceTable. �� ����.
		System.out.println("Child1�� �Ĵ� : "+c1.calcuate());
		System.out.println("Child2�� �Ĵ� : "+c2.calcuate());
	}
}
