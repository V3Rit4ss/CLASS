package com.lec.ex09_lib;

public interface ILendable { //�߻�޼ҵ� �� ���а͵�.
	public byte STATE_BORROWED = 1 ; //������ 
	public byte STATE_NORMAL = 0 ; // ���� ����
	public void checkOut(String borrowed, String checkOutDate); //���� ����
	public void checkIn(); //�ݳ�.
	public void printState(); //"�ڹ�" ȫ�浿 ����  ���Ⱑ��
	                          //"�ڹ�" ȫ�浿 ����  ������
}
