package com.lec.ex;
// Car myPorsche = new car();
//myPorsche.color = "red";
// Scanner sc = Scanner(~);
public class Car {
	private String color; // 클래스 안에는 (데이터[프라이빗] 들 )  
	private int cc;
	private int speed;
	public Car( ) { //생성자 함수 = 리턴타입이 없고 클래스명과 같은 이름의 메소드 //디폴트 생성자 함수는 생성자 함수가 없을때 JVM이 자동 생성 // = new ~ 할때 사용되는것
																											//개체 변수가 생성 될때 자동 호출
		cc = 1000;
	}
	public void drive( ) {  // 클래스 안에는  (메소드[퍼블릭] 들 )
		speed = 60;
		System.out.println("운전한다 지금 속도 : "+speed);
	}
	void park() {//퍼블릭 안써도 비슷함 근데 대대분 퍼블릭 넣고함
		speed = 0;
		System.out.println("주차한다 지금 속도 :"+speed);
	}
	void race() {
		speed = 120;
		System.out.println("레이싱한다. 지금 속도 :"+speed);
	}
	// ~.setColor("red")
	public void setColor(String color) {
		this.color = color; 
	}
	//~.getColor()
	public String getColor() {
		return color;
	}
	//~,getCc()
	public int getCc() {
		return cc;
	}
}
