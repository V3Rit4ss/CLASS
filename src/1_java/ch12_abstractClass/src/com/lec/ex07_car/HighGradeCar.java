package com.lec.ex07_car;

public class HighGradeCar extends Car {
	private int tax = 100000;
	public HighGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
	//	tax = 100000; ���� �γ� �Ʒ��� �γ� ����� ����. 
	}

	@Override
	public void getSpec() {
		System.out.println("###############################");
		System.out.println("�� �� : "+getColor());
		System.out.println("Ÿ�̾� : "+getTire());
		System.out.println("��ⷮ : "+getDisplacement());
		System.out.println("�� �� : "+getHandle());
		if(getDisplacement() > 1500) {
//			tax = tax + (getDisplacement() - 1500)*200;
			tax += (getDisplacement() - 1500)*200;
		}
		System.out.println("�� �� : "+tax);
		System.out.println("###############################");
		
	}

}
