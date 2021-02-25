package com.lec.q01.interfacae;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		BookLib[] booklib = { new BookLib("195ㅅ-289","소나기","황순원"),new BookLib("560ㅍ-889","FBI.행동의심리학"," 조.내버로, 마빈.칼린스"),new BookLib("209ㅇ-780","월야환담 채월야 1권","홍정훈")};
		
		Scanner sc= new Scanner(System.in);
		int fn, idx =0 ; //기능번호 1,대출 2,반납 3...   , 인덱스 booklib의
		String bTitle, borrower, checkOutDate;
		do {
			System.out.print("1. 대출 | 2. 반납 | 3. 도서 현황 | 0. 종료");
			fn = sc.nextInt();
			switch(fn) {
			case 1: 
				System.out.print("대출 하실 책 이름을 적어주세요.");
				bTitle = sc.next();
				for(idx = 0; idx<booklib.length; idx++) {
					if(bTitle.equals(booklib[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == booklib.length) {
					System.out.println("해당 도서는 없는 도서입니다.");
			}else if(booklib[idx].getState()==ILendable.STATE_BORROWED) {
				System.out.println(bTitle+"해당 도서는 현재 대출 중 입니다.");
				
			}else {
				System.out.print("대출하시는 분의 성명을 기입 해주세요.");
				borrower = sc.next();
				System.out.print("현재 대출 하신 날짜를 기입 해주세요.");
				checkOutDate = sc.next();
				booklib[idx].checkOut(borrower, checkOutDate);
			}
				break;
				
			case 2:
				System.out.print("반납 하실 도서의 이름을 기입 해주세요.");
				bTitle = sc.next();
				for(idx = 0; idx<booklib.length; idx++) {
					if(bTitle.equals(booklib[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == booklib.length) {
					System.out.println("현재 입력 하신 도서는 해당 기관의 도서가 아닙니다.");
				}else {
					booklib[idx].checkIn();
					System.out.println("기간 내에 반납을 해주셔서 감사합니다.");
				}
				break;
			case 3:
				for(BookLib booklib1 : booklib) {
					booklib1.printState();
				}
					
				}
		}while(fn != 0);
		System.out.println("감사합니다, 다음에 또 이용해주세요.");
		
	}
}
