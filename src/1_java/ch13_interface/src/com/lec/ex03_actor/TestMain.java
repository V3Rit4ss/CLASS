package com.lec.ex03_actor;  // 다중 implements (다중 구현) 를 이용한 다형성.

public class TestMain {

	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCatchCriminal();
		park.canSearch();
		park.makePizza();
		park.makeSpaghetti();
		park.outFire();
		park.saveMan();
		System.out.println("===============================");
		
		FireFighter firePark = park; //타입을 바꿈
		firePark.outFire();
		firePark.saveMan();
//		firePark.canCatchCriminal(); 안댐.
		System.out.println("=================================");
		
		PoliceMan policePark = park; //타입을 바꿈.
		policePark.canCatchCriminal();
		policePark.canSearch();
		System.out.println("=================================");
		
		Chef chefPark = park;	
		chefPark.makePizza();
		chefPark.makeSpaghetti();
	}

}
