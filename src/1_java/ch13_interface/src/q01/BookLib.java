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
	public void checkOut(String borrowed, String checkOutDate) { //�� ������ ��������.
		if(state != STATE_NORMAL) {
			System.out.println("���� ���� ���� �Դϴ�.");
			return ;
		}
		//å ���� �Ϸ�.
		state = STATE_BORROWED;
		System.out.println("\""+getBookTitle()+"\"������ ���� �Ǿ����ϴ�.");
	}

	@Override // b.checkIn()
	public void checkIn() {
		if(state != STATE_BORROWED) {
			System.out.println("���� ���� ������ �ƴմϴ�.");
			return;
		}
		//�ݳ�
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+getBookTitle()+"\" �� ������ �ݳ� �Ǿ����ϴ�.");
	}

	@Override
	public void printState() { //b.printState() -> å�̸�, ȫ�浿����  : ���� ���� or ������.
		if(state == STATE_NORMAL) {
			//���� ����.
			System.out.printf("%s , %s , %s���� : ���� ����\n",getBookNo(), getBookTitle() , getWriter());
		}else if (state == STATE_BORROWED) {
			
			System.out.printf("%s , %s , %s���� : ������\n", getBookNo(), getBookTitle() , getWriter());
			
		}else {
			
			System.out.printf("%s , %s , %s���� : ���� ���� �Դϴ�.\n ", getBookNo(), getBookTitle() , getWriter());
			
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
