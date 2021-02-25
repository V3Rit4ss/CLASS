package com.lec.squre;
//Squre s1 = new Squre()
//Squre s2 = new Squre(10);
//Scanner sc = new Scanner(System.in)
public class Squre {
	private int side;
	public Squre() {//디폴트 생성자 아무것도 안하는[매개변수없는 생성자] 그냥 만들어두는게 좋음 =>생성자 오버로딩
		System.out.println("매개변수 없는 생성자 호출됨");
	} 
	public Squre(int side) { //매개 변수 있는 생성자
		this.side = side;
		System.out.println("매개변수 있는 생성자 호출됨");
	}
	public int area( ) {
		return side * side;
	}
	//~.getSide()
	public int getSide( ) {
		return side;
	}
	//~.setSide(10)
	public void setSide(int side) {
		this.side = side;
	}
}
