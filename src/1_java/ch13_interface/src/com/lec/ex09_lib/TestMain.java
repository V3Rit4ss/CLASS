package com.lec.ex09_lib;

public class TestMain {
	public static void main(String[] args) {
		Book book1 = new Book("890��","�ڹ�","ȫ�浿");
		Book book2 = new Book("890��","�ϵ�","ȫ����");
		book1.checkIn();
		book1.checkOut("�ű浿", "201209");//���� ó�� �Ϸ�
		book1.checkOut("��浿", "201209");// �̻� ���
		book1.printState();
		book2.printState();
	}
}
