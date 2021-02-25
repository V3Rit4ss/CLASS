package com.lec.ex09_lib;

public class Book implements ILendable {
	private String bookNo; // 책 창구번호 ex.123ㄱ-1234나
	private String bookTitle; // 책 제목 ex.자바
	private String writer; // 저자
	private String borrower; // 대출인(입력)
	private String checkOutDate; // 대출일(입력)
	private byte state; // 대출 상태.

	public Book() {
	} // 디폴트 생성자

	public Book(String bookNo, String bookTitle, String writer) { //생성자.
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null ; checkOutDate = null; state = STATE_NORMAL;  넣어도 안넣어도 ㄱㅊ.
	}

	// new Book("890ㄱ - 102나", "자바" , "홍길동 저자")
	// b.checkOut("신길동", "201209");
	@Override
	public void checkOut(String borrower, String checkOutDate) { // 해당책의 상태
		if (state != STATE_NORMAL) {
			System.out.println("대출중인 도서 입니다.");
			return; // 값이 없으면 나를 호출했던 곳으로 감.
		}
		//대출처리 로직.
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		// "자바" 도서가 대출되었습니다.
		System.out.println("\"" + bookTitle + "\"도서가 대출 되었습니다."); // \" 쌍따옴표 연결된거를 닫힌게 아니다 라고 해준다.
	}

	@Override // b.checkIn()
	public void checkIn() {
		if (state != STATE_BORROWED) {  //이 if 문    확인하는것.
			System.out.println("대출 중인 도서가 아닙니다.");
			return;
		}
		// 반납 처리 로직.
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		// "자바" 도서가 반납 처리 되었습니다.
		System.out.println("\"" + bookTitle + "\"도서가 반납 되었습니다.");
	}

	// b.printState() -> 자바, 홍길동 저자 - 대출 가능(or대출중)
	@Override
	public void printState() {
		if (state == STATE_NORMAL) { // 대출가능
			
			System.out.printf("%s, %s저자 - 대출 가능\n", bookTitle, writer);
			
		} else if (state == STATE_BORROWED) { // 대출중
			
			System.out.printf("%s, %s저자 - 대출중\n", bookTitle, writer);
			
		}else {   
			
			System.out.printf("%s,%s - 유령 상태입니다.\n" , bookTitle, writer);
			
		}
//		String msg = bookTitle+" , "+writer + " - ";
//		msg += state==STATE_NORMAL ? "대출가능" : "대출중";  // 3항 연산자.
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
