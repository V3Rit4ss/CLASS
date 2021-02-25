package q01;

public interface ILendable {  
	public byte STATE_BORROWED = 1; // 대출 중.
	public byte STATE_NORMAL = 0; // 대출 가능.
	public void checkOut(String borrowed, String checkOutDate); // 대출을 할 내용의 로직.
	public void checkIn(); // 반납 .
	public void printState();    // "책 이름" "ㅁㅁㅁ 저자" 대출유무.  
}
