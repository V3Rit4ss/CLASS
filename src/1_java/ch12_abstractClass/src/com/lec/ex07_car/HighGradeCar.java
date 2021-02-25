package com.lec.ex07_car;

public class HighGradeCar extends Car {
	private int tax = 100000;
	public HighGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
	//	tax = 100000; 위에 두나 아래에 두나 상관은 없음. 
	}

	@Override
	public void getSpec() {
		System.out.println("###############################");
		System.out.println("색 상 : "+getColor());
		System.out.println("타이어 : "+getTire());
		System.out.println("배기량 : "+getDisplacement());
		System.out.println("핸 들 : "+getHandle());
		if(getDisplacement() > 1500) {
//			tax = tax + (getDisplacement() - 1500)*200;
			tax += (getDisplacement() - 1500)*200;
		}
		System.out.println("세 금 : "+tax);
		System.out.println("###############################");
		
	}

}
