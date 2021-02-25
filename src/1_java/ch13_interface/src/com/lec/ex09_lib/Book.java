package com.lec.ex09_lib;

public class Book implements ILendable {
	private String bookNo; // å â����ȣ ex.123��-1234��
	private String bookTitle; // å ���� ex.�ڹ�
	private String writer; // ����
	private String borrower; // ������(�Է�)
	private String checkOutDate; // ������(�Է�)
	private byte state; // ���� ����.

	public Book() {
	} // ����Ʈ ������

	public Book(String bookNo, String bookTitle, String writer) { //������.
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null ; checkOutDate = null; state = STATE_NORMAL;  �־ �ȳ־ ����.
	}

	// new Book("890�� - 102��", "�ڹ�" , "ȫ�浿 ����")
	// b.checkOut("�ű浿", "201209");
	@Override
	public void checkOut(String borrower, String checkOutDate) { // �ش�å�� ����
		if (state != STATE_NORMAL) {
			System.out.println("�������� ���� �Դϴ�.");
			return; // ���� ������ ���� ȣ���ߴ� ������ ��.
		}
		//����ó�� ����.
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		// "�ڹ�" ������ ����Ǿ����ϴ�.
		System.out.println("\"" + bookTitle + "\"������ ���� �Ǿ����ϴ�."); // \" �ֵ���ǥ ����ȰŸ� ������ �ƴϴ� ��� ���ش�.
	}

	@Override // b.checkIn()
	public void checkIn() {
		if (state != STATE_BORROWED) {  //�� if ��    Ȯ���ϴ°�.
			System.out.println("���� ���� ������ �ƴմϴ�.");
			return;
		}
		// �ݳ� ó�� ����.
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		// "�ڹ�" ������ �ݳ� ó�� �Ǿ����ϴ�.
		System.out.println("\"" + bookTitle + "\"������ �ݳ� �Ǿ����ϴ�.");
	}

	// b.printState() -> �ڹ�, ȫ�浿 ���� - ���� ����(or������)
	@Override
	public void printState() {
		if (state == STATE_NORMAL) { // ���Ⱑ��
			
			System.out.printf("%s, %s���� - ���� ����\n", bookTitle, writer);
			
		} else if (state == STATE_BORROWED) { // ������
			
			System.out.printf("%s, %s���� - ������\n", bookTitle, writer);
			
		}else {   
			
			System.out.printf("%s,%s - ���� �����Դϴ�.\n" , bookTitle, writer);
			
		}
//		String msg = bookTitle+" , "+writer + " - ";
//		msg += state==STATE_NORMAL ? "���Ⱑ��" : "������";  // 3�� ������.
//		System.out.println(msg);
	}

	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
}
