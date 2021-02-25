package q01;

public class BookLib extends BookInfo implements ILendable {
	
	private byte state;
	private String borrower;
	private String checkOutDate;
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		this.state = state;
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;

	}

	
	
	@Override
	public void checkOut(String borrowed, String checkOutDate) { //현 도서의 대출유무.
		if(state != STATE_NORMAL) {
			System.out.println("대출 중인 도서 입니다.");
			return ;
		}
		//책 대출 완료.
		state = STATE_BORROWED;
		System.out.println("\""+getBookTitle()+"\"도서가 대출 되었습니다.");
	}

	@Override // b.checkIn()
	public void checkIn() {
		if(state != STATE_BORROWED) {
			System.out.println("대출 중인 도서가 아닙니다.");
			return;
		}
		//반납
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+getBookTitle()+"\" 의 도서가 반납 되었습니다.");
	}

	@Override
	public void printState() { //b.printState() -> 책이름, 홍길동저자  : 대출 가능 or 배출중.
		if(state == STATE_NORMAL) {
			//대출 가능.
			System.out.printf("%s , %s , %s저자 : 대출 가능\n",getBookNo(), getBookTitle() , getWriter());
		}else if (state == STATE_BORROWED) {
			
			System.out.printf("%s , %s , %s저자 : 대출중\n", getBookNo(), getBookTitle() , getWriter());
			
		}else {
			
			System.out.printf("%s , %s , %s저자 : 유령 상태 입니다.\n ", getBookNo(), getBookTitle() , getWriter());
			
		}
	}



	public byte getState() {
		return state;
	}



	public String getBorrower() {
		return borrower;
	}



	public String getCheckOutDate() {
		return checkOutDate;
	}

}
