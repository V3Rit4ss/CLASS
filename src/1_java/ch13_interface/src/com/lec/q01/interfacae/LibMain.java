package com.lec.q01.interfacae;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		BookLib[] booklib = { new BookLib("195��-289","�ҳ���","Ȳ����"),new BookLib("560��-889","FBI.�ൿ�ǽɸ���"," ��.������, ����.Į����"),new BookLib("209��-780","����ȯ�� ä���� 1��","ȫ����")};
		
		Scanner sc= new Scanner(System.in);
		int fn, idx =0 ; //��ɹ�ȣ 1,���� 2,�ݳ� 3...   , �ε��� booklib��
		String bTitle, borrower, checkOutDate;
		do {
			System.out.print("1. ���� | 2. �ݳ� | 3. ���� ��Ȳ | 0. ����");
			fn = sc.nextInt();
			switch(fn) {
			case 1: 
				System.out.print("���� �Ͻ� å �̸��� �����ּ���.");
				bTitle = sc.next();
				for(idx = 0; idx<booklib.length; idx++) {
					if(bTitle.equals(booklib[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == booklib.length) {
					System.out.println("�ش� ������ ���� �����Դϴ�.");
			}else if(booklib[idx].getState()==ILendable.STATE_BORROWED) {
				System.out.println(bTitle+"�ش� ������ ���� ���� �� �Դϴ�.");
				
			}else {
				System.out.print("�����Ͻô� ���� ������ ���� ���ּ���.");
				borrower = sc.next();
				System.out.print("���� ���� �Ͻ� ��¥�� ���� ���ּ���.");
				checkOutDate = sc.next();
				booklib[idx].checkOut(borrower, checkOutDate);
			}
				break;
				
			case 2:
				System.out.print("�ݳ� �Ͻ� ������ �̸��� ���� ���ּ���.");
				bTitle = sc.next();
				for(idx = 0; idx<booklib.length; idx++) {
					if(bTitle.equals(booklib[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == booklib.length) {
					System.out.println("���� �Է� �Ͻ� ������ �ش� ����� ������ �ƴմϴ�.");
				}else {
					booklib[idx].checkIn();
					System.out.println("�Ⱓ ���� �ݳ��� ���ּż� �����մϴ�.");
				}
				break;
			case 3:
				for(BookLib booklib1 : booklib) {
					booklib1.printState();
				}
					
				}
		}while(fn != 0);
		System.out.println("�����մϴ�, ������ �� �̿����ּ���.");
		
	}
}
