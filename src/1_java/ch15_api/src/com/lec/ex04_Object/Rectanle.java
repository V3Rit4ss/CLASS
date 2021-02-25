package com.lec.ex04_Object;
// 색상을 막고싶으면 enum.
public class Rectanle {
	private int garo;
	private int sero;
	private String color;
	
	public Rectanle () { //()괄호 안에 변수넣는자리. 없으면 매개변수 없는 생성자.
		
		this.garo = 0;
		this.sero = 0;
		color = "검정";
	}

	public Rectanle(int garo, int sero, String color) {
		
		this.garo = garo;
		this.sero = sero;
		this.color = color;
	}

	@Override
	public String toString() {
		return garo+"cm "+ sero + "cm " + " 색상 :" + color + " 사각형.";
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj != null && obj instanceof Rectanle) {
			
			boolean garoCm = this.garo == ((Rectanle)obj).garo;
			boolean seroCm = this.sero == ((Rectanle)obj).sero;
			boolean colorChk = this.color.equals(((Rectanle)obj).color);
			//스트링을 비교하고싶을때는 디스.선언문.equals(((클래스이름)obj).선언문
			return garoCm && seroCm && colorChk;
		}
		return false;
	}
	
}
