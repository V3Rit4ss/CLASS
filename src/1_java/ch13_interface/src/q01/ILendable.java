package q01;

public interface ILendable {  
	public byte STATE_BORROWED = 1; // ���� ��.
	public byte STATE_NORMAL = 0; // ���� ����.
	public void checkOut(String borrowed, String checkOutDate); // ������ �� ������ ����.
	public void checkIn(); // �ݳ� .
	public void printState();    // "å �̸�" "������ ����" ��������.  
}
