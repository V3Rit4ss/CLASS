package com.lec.ex06_lunch;
//Child1 c = new Child1(300,1000,100,300,800,350); 
public class Child1 extends LunchMenu {
	
	public Child1(int rice, int bulgogi, int soup, int banana, int mlik, int almond) {
		super(rice, bulgogi, soup, banana, mlik, almond); //매개변수가 없는 생성자가 없기에 슈퍼를 썼다.
		
	}

	@Override
	public int calcuate() { //우유 알러지 있는 그룹
		
		return getRice()+getBulgogi()+getSoup()+getBanana()+getAlmond();
	}

}
