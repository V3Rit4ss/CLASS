package com.lec.ex06_lunch;

public class Child2 extends LunchMenu {

	public Child2(int rice, int bulgogi, int soup, int banana, int mlik, int almond) {
		super(rice, bulgogi, soup, banana, mlik, almond);
		
	}

	@Override
	public int calcuate() { // ���� �˷��� ���� �׷�
		
		return getRice()+getBulgogi()+getSoup()+getMlik();
	}

}
