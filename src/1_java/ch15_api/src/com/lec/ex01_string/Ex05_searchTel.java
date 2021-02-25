package com.lec.ex01_string;

import java.util.Scanner;

public class Ex05_searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-9999-7777" , "010-8888-8888" , "010-7777-7777"} ;//9999 - > 7777로 바꿔서 중복이있게 한다면?
				Scanner sc = new Scanner(System.in);
				int idx; // 전화번호가 중복이 없을때.
				System.out.println("찾고자 하는 전화번호 뒷자리 : ");
				String searchTel = sc.next();//ex.입력한 번호 8888 
				for(idx = 0; idx<tels.length ; idx++) {
					String temp = tels[idx];
					String post = temp.substring(temp.lastIndexOf("-")+1); 
					if(searchTel.equals(post)) {
						System.out.println("번호 전체는 "+tels[idx]);  // tels[idx] -> temp.
						break;
						
					}//if
				}//for
				if(idx == tels.length) {
					System.out.println("입력하신 전화번호는 없는 번호입니다.");
				}
				
				
				
				
				
				
				
				
				
				
		}//main
	}//class

