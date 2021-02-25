package com.lec.ex5_momchild;//스태틱을 써야만 하는 상황.
//Child child = new Child("첫째 똘똘이");
//child1.takeMoney(100);
public class Child {
	private String name; //변수의 주머니만
	static MomPouch momPouch = new MomPouch();  // 스태틱은 항상켜져있는 서버 라 생각하면댐 누적 데이터로 과후바 생길수있음
	public Child(String name) {
		this.name= name;
		
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
		//	momPouch.money = momPouch.money - money ; 이거보다는 아래있는걸로 함
			momPouch.money -= money ;
			System.out.println(name+"가"+money+"가져가서 엄마지갑엔"+momPouch.money);
		}else {
			System.out.println(name+"가 돈을 못받음. 현재 엄마돈은"+momPouch.money);
		}
	}
}
