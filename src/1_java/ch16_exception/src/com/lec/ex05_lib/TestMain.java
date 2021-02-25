package com.lec.ex05_lib;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) throws Exception {
		BookLib[] books = { new BookLib("123-455", "�ڹ�", "�ڶ�") , new BookLib("123-45", "ȫ", "����")};
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx=0;
		String bookTitle, borrower;
		do {
			System.out.print("[ 0.���� ��Ȳ  ] . [ 01. ���� ] . [ 02. �ݳ� ] ..[�� �� ���ڸ� �Է� �ϸ� ���α׷��� ���ᰡ �˴ϴ�. ");
			
			try {
					fn = sc.nextInt();
			}catch (Exception e) {
				System.out.println("0,1,2,3 �� ���ڸ� �Է��Ͻø� ���α׷��� ���� �˴ϴ�.");
				break;
			}
			
		switch(fn) {
		case 0:
			
			for(BookLib book : books) {
				System.out.println(book);
			}
			break;
		case 1:
			System.out.print("���� �Ͻ� ������ �̸��� �Է� ���ּ���.");
				sc.nextLine();
				bookTitle = sc.nextLine();
			for(idx = 0; idx<books.length; idx++) {
				if(books[idx].getBookTitle().equals(bookTitle)) {
					break;
				}
			}
			if(idx == books.length) {
				System.out.println("���� �Է��Ͻ� ������ �ش� ����� ���� ���� �Դϴ�.");
			}else if(books[idx].getState() == BookLib.STATE_BORROWED) {
				System.out.println(bookTitle+"�ش� ������ ���� ���� �� �Դϴ�.");
			}else {
				System.out.print("�����Ͻô� ���� ������ �������ּ���.");
					borrower = sc.next();
					try {
						books[idx].checkOut(borrower);
					}catch (Exception e) {
						System.out.println(e.getMessage());
					} 
				//��¥.
			}
			break;
		case 2:
			System.out.print("�ݳ� �Ͻ� ������ �̸��� �Է� ���ּ���.");
			sc.nextLine();
			bookTitle = sc.nextLine();
			for(idx= 0; idx<books.length; idx++) {
				if(books[idx].getBookTitle().equals(bookTitle)) {
				break;
			}
		}
		if(idx == books.length) {
			System.out.println("���� �Է� �Ͻ� ������ �ش� ����� ���� ���� �Դϴ�.");
		}else {
			try {
				books[idx].checkIn();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		//	book[idx].checkIn();
			//System.out.println("���� �������� �ݳ��� ���ּż� �����մϴ�.");
		}
			break;
			
//		case 3:
//			for(BookLib books : book) {
//				System.out.println(book);
//			}
//			break;
			
		default:
			System.out.println("0,1,2 �� �� ���ڸ� �Է�  �Ͻø� ���α׷��� ����˴ϴ�.");
		
			
		}
		}while (fn == 0 || fn ==1 || fn ==2 );
		System.out.println("�����մϴ�, ������ �� �̿����ּ���.");
		
		sc.close();
		
		
	}
}
