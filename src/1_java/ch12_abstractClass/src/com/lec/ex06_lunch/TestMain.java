package com.lec.ex06_lunch;

import com.lec.cons.PriceTable;

public class TestMain {
	public static void main(String[] args) {
		Child1 c1 = new Child1(PriceTable.RICE , PriceTable.BULGOGI , PriceTable.SOUP , PriceTable.BANANA , PriceTable.MILK , PriceTable.ALMOND);   //상수들 모아둔 곳에서 수정해면댐
		Child2 c2 = new Child2(PriceTable.RICE , PriceTable.BULGOGI , PriceTable.SOUP , PriceTable.BANANA , PriceTable.MILK , PriceTable.ALMOND); //PriceTable. 에 가서.
		System.out.println("Child1형 식대 : "+c1.calcuate());
		System.out.println("Child2형 식대 : "+c2.calcuate());
	}
}
