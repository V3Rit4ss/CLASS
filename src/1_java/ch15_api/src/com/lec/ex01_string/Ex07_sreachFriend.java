package com.lec.ex01_string;

import java.util.Scanner;

//���� ���ڸ��� ģ�� ã��.
public class Ex07_sreachFriend {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿","010-9999-9999", "12-14") , new Friend("�ű浿","010-9999-8888", "08-14") , new Friend("���̼�","010-9999-7777", "01-14") , new Friend("�浿","010-4444-9999", "02-04")}; 
		//ã�� ģ���� ��ȭ��ȣ ���ڸ��� �Է� ����.
		//������s �迭���� �ش� ��ȭ��ȣ ���ڸ��� ���� ģ���� ������ ��ģ���� ��� and ������ ���ٰ� ���.
		Scanner sc = new Scanner(System.in);
		System.out.print("ã�� ���� ģ���� ��ȭ��ȣ ���ڸ���.");
		String sreachTel = sc.next();
		int idx; boolean searchOk = false;

		for(idx = 0; idx<friends.length; idx++) {
			String temp = friends[idx].getTel();
			String post = temp.substring(temp.lastIndexOf("-")+1);
			if(sreachTel.equals(post)) {
				System.out.println(friends[idx]); // ����Ʈ�� �Ƚᵵ ����.
				//friends[idx].print();
				searchOk = true;
				//break;  �ߺ��������� �긯������ �ȴ� ������ ���ƾ��ϴϱ�.
			}//if
		}//for
		if(!searchOk) {
			System.out.println("�ش� ��ȣ�� ģ���� �����ϴ�.");
		}
			
	
	}
}
