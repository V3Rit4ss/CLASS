package com.lec.ex05_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bookNo;
	private String bookTitle;
	private String writer;
	private byte state;
	private String borrower;
	private Date checkOutDate;

	public void bookLib () {}
	

	public BookLib(String bookNo, String bookTitle, String writer ){
		
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		state = STATE_NORMAL;
		
		
		
	}


	@Override
	public void checkOut(String borrower) throws Exception {
		if(state != STATE_NORMAL) {
			throw new Exception(bookTitle+"은 대출 중 입니다.");
			
		}
		
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		
		System.out.println("대출자 : "+borrower);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년-MM월-dd일(E) HH시 : mm분");
		System.out.println("대출 날짜 : "+sdf.format(checkOutDate)+"\""+bookTitle+"\"도서가 대출 되었습니다.");
		
		
		
	}

	@Override
	public void checkIn() throws Exception {
		if(state != STATE_BORROWED) {
			throw new Exception(bookTitle+"대출 중이 아닙니다.");
			
		}
		Date now = new Date();
		
		long diff = now.getTime()/*;//*/ - checkOutDate.getTime();
		long day = diff / (1000*60*60*24);//24부터 거꾸로 해보기.
		if(day>14) {
			System.out.println("연체료는 하루당 1000원이 부과가 됩니다.");
			day = day-14;
			System.out.println("내셔야 할 연체료는"+(day*1000)+"원");
			Scanner sc = new Scanner(System.in);
			System.out.print("연체료"+(day*1000)+"원 을 지불 하셨습니까?(Y/N)");
			
			if(!sc.next().equalsIgnoreCase("y")) {
				
				System.out.println("연체료를 지불 하셔야 반납처리가 가능합니다.");
				return;
			}
			
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle+"의 도서가 반납되었습니다.");
		
	}
		
		


	@Override
	public String toString() {
		String temp = "\""+bookTitle+"("+bookNo+")\" "+writer+" 저자";
		if(state == STATE_NORMAL) {
			temp += " 대출가능";
		}else if (state == STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd E요일");
			
			temp += " 대출 중 "+sdf.format(checkOutDate)+")";
			
		}else {
			temp += "유령 상태";
		}
		return temp;
	}


	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}


	
	public String getBookTitle() {
		return bookTitle;
	}


	

	public byte getState() {
		return state;
	}


	
	
	
	

}
