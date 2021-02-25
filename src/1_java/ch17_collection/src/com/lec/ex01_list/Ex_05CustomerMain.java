package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_05CustomerMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name , phone ,address ;
		ArrayList<Customer> customers = new ArrayList<Customer>();  //   =>  기존 배열. Customer[] cs = new Customer[10];
		do {
			System.out.print("회원가입을 하시겠습니까? (Y/N) ");
			answer = sc.next();   //넥스트로 받던 라인으로 받던 상관은없지만 버퍼 생각해서 해야함,
			if(answer.equalsIgnoreCase("y")) {  //회원가입 진행.  y 와 Y 구별없게할려면
				System.out.print("가입 하실 회원님의 이름은?");
				name = sc.next();  //스페이스바가 안들어간다면 넥스트 들어간다면 라인
				System.out.print("가입 하실 회원님의 전화번호는?");
				phone = sc.next();
				System.out.print("가입 하실 회원님의 주소는?");
				sc.nextLine(); // 버퍼 지우는 용도.
				address = sc.nextLine();
//				Customer temp = new Customer(name, phone ,address);
//				customers.add(temp); 이렇게 안하고
				customers.add(new Customer(name, phone, address));  //요롷게
			}else if(answer.equalsIgnoreCase("n")) {
				break;
			}
			
		}while(!answer.equalsIgnoreCase("n"));  //true 로 해도 상관은 없지만 가독성을 따져서..
			System.out.println("가입한 회원 리스트 목록");
			for(Customer customer : customers) {//확장for
				System.out.println(customer);
			}
//		for(int idx=0; idx<customers.size(); idx++) {//일반 for
//			System.out.println(customers.get(idx));
//		}
//		
		
		
	}//class
}//main
