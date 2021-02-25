package com.lec.ex07_car;

public abstract class Car {
	private String color ;  // 색상 // final 대문자만 상수로 
	private String tire ;  // 타이어
	private int displacement; // 배기량
	private String handle; //핸들
	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	public abstract void getSpec(); //선언만 해주면 추상 메소드.
	//겟터만 넣음.
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
