package com.lec.ex06_lunch;
//Child1 c = new Child1(300,1000,100,300,800,350);    
//Child2 c = new Child1(300,1000,100,300,800,350);   
public abstract class LunchMenu {
	//1인 기준
	private int rice;    //쌀값
	private int bulgogi; //불고기값
	private int soup;    //국값
	private int banana; //바나나값
	private int mlik; //우유값
	private int almond; // 아몬드값
//	public LunchMenu() {}  매개변수 없는 생성자 없을때 차일드1번 가서 보면 ~
	public LunchMenu(int rice, int bulgogi, int soup, int banana, int mlik, int almond) { //생성자.
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.banana = banana;
		this.mlik = mlik;
		this.almond = almond;
	}
	//식대 계산 하는 추상메소드
	public abstract int calcuate();
	
	//===================================
	public int getRice() { //겟터만 필요해서 겟터만 만듬 겟,셋 다 만들어도 댐
		return rice;
	}
	public int getBulgogi() {
		return bulgogi;
	}
	public int getSoup() {
		return soup;
	}
	public int getBanana() {
		return banana;
	}
	public int getMlik() {
		return mlik;
	}
	public int getAlmond() {
		return almond;
	}
	
}
