package com.lec.ex09_lib;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		Book[] books = { new Book("890ㄱ-100" ,"java" ,"아무개") ,new Book("890ㄱ-101" ,"hadoop" ,"지우개"), new Book("890ㄱ-102" ,"oracle" ,"이무개"),new Book("890ㄱ-103" ,"python" ,"김무개"),new Book("892ㄱ-100" ,"spark" ,"신무개") };
		
		Scanner sc = new Scanner(System.in);
		int fn, idx=0;  //기능번호(1: 대출 , 2: 반납...) , 인데스(books의)
		String bTitle, borrower, checkOutDate; // 책제목, 대출인 , 대출일
		do {
			System.out.print("1: 대출 | 2: 반납 | 3: 도서 현황 | 0: 종료");
			fn = sc.nextInt();
			switch(fn) {
			case 1 : //책이름 -> 책 조회 (배열) -> 대출중인지 Book에서 했음.(해당 책의 상태) -> 대출인,대출일 -> 대출(메소드)
		//		System.out.println("대출 진행");
				System.out.print("대출할 책이름은?"); //책이름 입력
				bTitle = sc.next(); //스트링을 받기위해 next()
				for(idx= 0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) { //책이름 찼았다. 해당 idx번째 대출하러 가자
						break;
					}
				}
				//책조회해서 책을 찾았는지 , 못찾았는지 보고 대출 진행
				if(idx == books.length) {//못찾음.  idx는 4 까지 books.length 최대 5. 01234 = 5개.
					System.out.println("해당 책이 없습니다.");
				}else if(books[idx].getState()==ILendable.STATE_BORROWED) {//찾음 - idx 번째 대출 진행.
					System.out.println(bTitle+"도서는 대출중입니다.");
					
				}else {
					//대출 가능하니 대출인,대출입 입력받고 대출진행
					System.out.print("대출인은?");
					borrower = sc.next();
					System.out.print("대출일은?");
					checkOutDate = sc.next();
					books[idx].checkOut(borrower, checkOutDate);
				}
				break;
				
			case 2: //책 이름 -> 책 조회(배열) -> 반납
				System.out.print("반납 할 도서 이름은?");
				bTitle = sc.next();
				for(idx = 0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						
						break;
						
					}
				}
				if(idx == books.length) {//못찾음
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
				}else {
					books[idx].checkIn();
					System.out.println("반납 해주셔서 감사합니다.");
				}
				break;
			case 3: //for문을 이용해서 도서상태 출력
//				System.out.println("도서 상태 출력");
				for(Book book : books) { //books 배열변수
					book.printState();
				}
//			case 0: //
//				break; // 스위치 문을 빠져나와서 다시 두화일문에 들어간다.
			}
		}while(fn != 0);
		System.out.println("시스템 종료");
	}
}
