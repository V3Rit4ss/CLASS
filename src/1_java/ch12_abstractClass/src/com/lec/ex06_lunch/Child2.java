package com.lec.ex06_lunch;

public class Child2 extends LunchMenu {

	public Child2(int rice, int bulgogi, int soup, int banana, int mlik, int almond) {
		super(rice, bulgogi, soup, banana, mlik, almond);
		
	}

	@Override
	public int calcuate() { // 우유 알러지 없는 그룹
		
		return getRice()+getBulgogi()+getSoup()+getMlik();
	}

}
