package com.lec.ex05_lib;

import java.util.Scanner;

public interface ILendable {
	public byte STATE_BORROWED = 1;
	public byte STATE_NORMAL = 0;
	public void checkOut(String borrower) throws Exception ;
	public void checkIn() throws Exception ;
//	public void ����Ʈ������Ʈ.�� ����Ʈ������ �ٲ����.
}
