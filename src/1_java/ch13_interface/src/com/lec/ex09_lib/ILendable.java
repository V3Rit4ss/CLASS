package com.lec.ex09_lib;

public interface ILendable { //추상메소드 로 빼둔것들.
	public byte STATE_BORROWED = 1 ; //대출중 
	public byte STATE_NORMAL = 0 ; // 대출 가능
	public void checkOut(String borrowed, String checkOutDate); //대출 로직
	public void checkIn(); //반납.
	public void printState(); //"자바" 홍길동 저자  대출가능
	                          //"자바" 홍길동 저자  대출중
}
