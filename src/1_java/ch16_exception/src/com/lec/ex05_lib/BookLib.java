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
			throw new Exception(bookTitle+"�� ���� �� �Դϴ�.");
			
		}
		
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		
		System.out.println("������ : "+borrower);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��-MM��-dd��(E) HH�� : mm��");
		System.out.println("���� ��¥ : "+sdf.format(checkOutDate)+"\""+bookTitle+"\"������ ���� �Ǿ����ϴ�.");
		
		
		
	}

	@Override
	public void checkIn() throws Exception {
		if(state != STATE_BORROWED) {
			throw new Exception(bookTitle+"���� ���� �ƴմϴ�.");
			
		}
		Date now = new Date();
		
		long diff = now.getTime()/*;//*/ - checkOutDate.getTime();
		long day = diff / (1000*60*60*24);//24���� �Ųٷ� �غ���.
		if(day>14) {
			System.out.println("��ü��� �Ϸ�� 1000���� �ΰ��� �˴ϴ�.");
			day = day-14;
			System.out.println("���ž� �� ��ü���"+(day*1000)+"��");
			Scanner sc = new Scanner(System.in);
			System.out.print("��ü��"+(day*1000)+"�� �� ���� �ϼ̽��ϱ�?(Y/N)");
			
			if(!sc.next().equalsIgnoreCase("y")) {
				
				System.out.println("��ü�Ḧ ���� �ϼž� �ݳ�ó���� �����մϴ�.");
				return;
			}
			
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle+"�� ������ �ݳ��Ǿ����ϴ�.");
		
	}
		
		


	@Override
	public String toString() {
		String temp = "\""+bookTitle+"("+bookNo+")\" "+writer+" ����";
		if(state == STATE_NORMAL) {
			temp += " ���Ⱑ��";
		}else if (state == STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd E����");
			
			temp += " ���� �� "+sdf.format(checkOutDate)+")";
			
		}else {
			temp += "���� ����";
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
