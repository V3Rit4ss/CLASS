package com.lec.ex01_string;

import java.util.Scanner;

public class Ex05_searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-9999-7777" , "010-8888-8888" , "010-7777-7777"} ;//9999 - > 7777�� �ٲ㼭 �ߺ����ְ� �Ѵٸ�?
				Scanner sc = new Scanner(System.in);
				int idx; // ��ȭ��ȣ�� �ߺ��� ������.
				System.out.println("ã���� �ϴ� ��ȭ��ȣ ���ڸ� : ");
				String searchTel = sc.next();//ex.�Է��� ��ȣ 8888 
				for(idx = 0; idx<tels.length ; idx++) {
					String temp = tels[idx];
					String post = temp.substring(temp.lastIndexOf("-")+1); 
					if(searchTel.equals(post)) {
						System.out.println("��ȣ ��ü�� "+tels[idx]);  // tels[idx] -> temp.
						break;
						
					}//if
				}//for
				if(idx == tels.length) {
					System.out.println("�Է��Ͻ� ��ȭ��ȣ�� ���� ��ȣ�Դϴ�.");
				}
				
				
				
				
				
				
				
				
				
				
		}//main
	}//class

