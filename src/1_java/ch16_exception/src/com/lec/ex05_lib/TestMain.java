package com.lec.ex05_lib;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) throws Exception {
		BookLib[] books = { new BookLib("123-455", "자바", "자랑") , new BookLib("123-45", "홍", "하하")};
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx=0;
		String bookTitle, borrower;
		do {
			System.out.print("[ 0.도서 현황  ] . [ 01. 대출 ] . [ 02. 반납 ] ..[그 외 문자를 입력 하면 프로그램이 종료가 됩니다. ");
			
			try {
					fn = sc.nextInt();
			}catch (Exception e) {
				System.out.println("0,1,2,3 외 문자를 입력하시면 프로그램이 종료 됩니다.");
				break;
			}
			
		switch(fn) {
		case 0:
			
			for(BookLib book : books) {
				System.out.println(book);
			}
			break;
		case 1:
			System.out.print("대출 하실 도서의 이름을 입력 해주세요.");
				sc.nextLine();
				bookTitle = sc.nextLine();
			for(idx = 0; idx<books.length; idx++) {
				if(books[idx].getBookTitle().equals(bookTitle)) {
					break;
				}
			}
			if(idx == books.length) {
				System.out.println("현재 입력하신 도서는 해당 기관에 없는 도서 입니다.");
			}else if(books[idx].getState() == BookLib.STATE_BORROWED) {
				System.out.println(bookTitle+"해당 도서는 현재 대출 중 입니다.");
			}else {
				System.out.print("대출하시는 분의 성명을 기입해주세요.");
					borrower = sc.next();
					try {
						books[idx].checkOut(borrower);
					}catch (Exception e) {
						System.out.println(e.getMessage());
					} 
				//날짜.
			}
			break;
		case 2:
			System.out.print("반납 하실 도서의 이름을 입력 해주세요.");
			sc.nextLine();
			bookTitle = sc.nextLine();
			for(idx= 0; idx<books.length; idx++) {
				if(books[idx].getBookTitle().equals(bookTitle)) {
				break;
			}
		}
		if(idx == books.length) {
			System.out.println("현재 입력 하신 도서는 해당 기관에 없는 도서 입니다.");
		}else {
			try {
				books[idx].checkIn();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		//	book[idx].checkIn();
			//System.out.println("저희 도서관에 반납을 해주셔서 감사합니다.");
		}
			break;
			
//		case 3:
//			for(BookLib books : book) {
//				System.out.println(book);
//			}
//			break;
			
		default:
			System.out.println("0,1,2 그 외 문자를 입력  하시면 프로그램이 종료됩니다.");
		
			
		}
		}while (fn == 0 || fn ==1 || fn ==2 );
		System.out.println("감사합니다, 다음에 또 이용해주세요.");
		
		sc.close();
		
		
	}
}
