package com.lec.ex01_string;

import java.util.Scanner;

public class Ex06_searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-9999-7777" , "010-8888-8888" , "010-7777-7777"} ;//9999 - > 7777�� �ٲ㼭 �ߺ����ְ� �Ѵٸ�?
				Scanner sc = new Scanner(System.in);
			//for�� �ȿ��� ����.	int idx; // ��ȭ��ȣ�� �ߺ��� ������.
				boolean sreachOk=false;  //�ؽ�Ʈ�� ��Ʈ���̸� �Ҹ� ���� �ؾ���.
				System.out.print("ã���� �ϴ� ��ȭ��ȣ ���ڸ� : ");
				String searchTel = sc.next();//ex.�Է��� ��ȣ 1111
				for(int idx = 0; idx<tels.length ; idx++) {
					String temp = tels[idx];
					String post = temp.substring(temp.lastIndexOf("-")+1); 
					if(searchTel.equals(post)) {
						System.out.println("��ȣ ��ü�� "+tels[idx]);  // tels[idx] -> temp.
						sreachOk = true; //
						
					}//if
				}//for
				if(!sreachOk) {//��ġ�����̰� Ʈ�簡 !(�ƴϸ�) ��.
					System.out.println("�Է��Ͻ� ��ȭ��ȣ�� ���� ��ȣ�Դϴ�.");
				}
				
				
				
				
				
				
				
				
				
				
		}//main
	}//class

