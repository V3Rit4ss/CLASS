package com.lec.ex09_lib;

public class TestMain {
	public static void main(String[] args) {
		Book book1 = new Book("890ㅁ","자바","홍길동");
		Book book2 = new Book("890ㅂ","하둡","홍끼리");
		book1.checkIn();
		book1.checkOut("신길동", "201209");//대출 처리 완료
		book1.checkOut("김길동", "201209");// 이상 경고
		book1.printState();
		book2.printState();
	}
}
