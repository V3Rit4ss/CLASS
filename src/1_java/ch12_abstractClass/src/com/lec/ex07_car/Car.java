package com.lec.ex07_car;

public abstract class Car {
	private String color ;  // ���� // final �빮�ڸ� ����� 
	private String tire ;  // Ÿ�̾�
	private int displacement; // ��ⷮ
	private String handle; //�ڵ�
	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	public abstract void getSpec(); //���� ���ָ� �߻� �޼ҵ�.
	//���͸� ����.
	public String getColor() {  
		return color;
	}
	public String getTire() {
		return tire;
	}
	public int getDisplacement() {
		return displacement;
	}
	public String getHandle() {
		return handle;
	}
	
}
