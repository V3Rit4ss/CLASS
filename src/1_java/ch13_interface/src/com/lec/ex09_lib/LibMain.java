package com.lec.ex09_lib;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		Book[] books = { new Book("890��-100" ,"java" ,"�ƹ���") ,new Book("890��-101" ,"hadoop" ,"���찳"), new Book("890��-102" ,"oracle" ,"�̹���"),new Book("890��-103" ,"python" ,"�蹫��"),new Book("892��-100" ,"spark" ,"�Ź���") };
		
		Scanner sc = new Scanner(System.in);
		int fn, idx=0;  //��ɹ�ȣ(1: ���� , 2: �ݳ�...) , �ε���(books��)
		String bTitle, borrower, checkOutDate; // å����, ������ , ������
		do {
			System.out.print("1: ���� | 2: �ݳ� | 3: ���� ��Ȳ | 0: ����");
			fn = sc.nextInt();
			switch(fn) {
			case 1 : //å�̸� -> å ��ȸ (�迭) -> ���������� Book���� ����.(�ش� å�� ����) -> ������,������ -> ����(�޼ҵ�)
		//		System.out.println("���� ����");
				System.out.print("������ å�̸���?"); //å�̸� �Է�
				bTitle = sc.next(); //��Ʈ���� �ޱ����� next()
				for(idx= 0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) { //å�̸� á�Ҵ�. �ش� idx��° �����Ϸ� ����
						break;
					}
				}
				//å��ȸ�ؼ� å�� ã�Ҵ��� , ��ã�Ҵ��� ���� ���� ����
				if(idx == books.length) {//��ã��.  idx�� 4 ���� books.length �ִ� 5. 01234 = 5��.
					System.out.println("�ش� å�� �����ϴ�.");
				}else if(books[idx].getState()==ILendable.STATE_BORROWED) {//ã�� - idx ��° ���� ����.
					System.out.println(bTitle+"������ �������Դϴ�.");
					
				}else {
					//���� �����ϴ� ������,������ �Է¹ް� ��������
					System.out.print("��������?");
					borrower = sc.next();
					System.out.print("��������?");
					checkOutDate = sc.next();
					books[idx].checkOut(borrower, checkOutDate);
				}
				break;
				
			case 2: //å �̸� -> å ��ȸ(�迭) -> �ݳ�
				System.out.print("�ݳ� �� ���� �̸���?");
				bTitle = sc.next();
				for(idx = 0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						
						break;
						
					}
				}
				if(idx == books.length) {//��ã��
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
				}else {
					books[idx].checkIn();
					System.out.println("�ݳ� ���ּż� �����մϴ�.");
				}
				break;
			case 3: //for���� �̿��ؼ� �������� ���
//				System.out.println("���� ���� ���");
				for(Book book : books) { //books �迭����
					book.printState();
				}
//			case 0: //
//				break; // ����ġ ���� �������ͼ� �ٽ� ��ȭ�Ϲ��� ����.
			}
		}while(fn != 0);
		System.out.println("�ý��� ����");
	}
}
