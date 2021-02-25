package com.lec.ex03_actor;  // ���� implements (���� ����) �� �̿��� ������.

public class TestMain {

	public static void main(String[] args) {
		Actor park = new Actor("�ں���");
		park.canCatchCriminal();
		park.canSearch();
		park.makePizza();
		park.makeSpaghetti();
		park.outFire();
		park.saveMan();
		System.out.println("===============================");
		
		FireFighter firePark = park; //Ÿ���� �ٲ�
		firePark.outFire();
		firePark.saveMan();
//		firePark.canCatchCriminal(); �ȴ�.
		System.out.println("=================================");
		
		PoliceMan policePark = park; //Ÿ���� �ٲ�.
		policePark.canCatchCriminal();
		policePark.canSearch();
		System.out.println("=================================");
		
		Chef chefPark = park;	
		chefPark.makePizza();
		chefPark.makeSpaghetti();
	}

}
