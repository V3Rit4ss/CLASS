package com.lec.ex06_lunch;
//Child1 c = new Child1(300,1000,100,300,800,350); 
public class Child1 extends LunchMenu {
	
	public Child1(int rice, int bulgogi, int soup, int banana, int mlik, int almond) {
		super(rice, bulgogi, soup, banana, mlik, almond); //�Ű������� ���� �����ڰ� ���⿡ ���۸� ���.
		
	}

	@Override
	public int calcuate() { //���� �˷��� �ִ� �׷�
		
		return getRice()+getBulgogi()+getSoup()+getBanana()+getAlmond();
	}

}
