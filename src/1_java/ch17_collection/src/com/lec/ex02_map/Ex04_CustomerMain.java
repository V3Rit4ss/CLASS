package com.lec.ex02_map;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.lec.ex01_list.Customer;

public class Ex04_CustomerMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;

		HashMap<String, Customer> customers = new HashMap<String, Customer>();

		while (true) {
			System.out.print("회원가입을 하시겠습니까? (Y/N) ");
			answer = sc.next(); // 넥스트로 받던 라인으로 받던 상관은없지만 버퍼 생각해서 해야함,
			if (answer.equalsIgnoreCase("n")) { // 회원가입 진행. y 와 Y 구별없게할려면
				break;
			} else if (answer.equalsIgnoreCase("y")) {

				System.out.print("가입 하실 회원님의 이름은?");
				name = sc.nextLine(); // 스페이스바가 안들어간다면 넥스트 들어간다면 라인
				System.out.print("가입 하실 회원님의 전화번호는?");
				phone = sc.nextLine();
				System.out.print("가입 하실 회원님의 주소는?");
				sc.nextLine(); // 버퍼 지우는 용도.
				address = sc.nextLine();
				customers.put(phone, new Customer(name, phone, address));

			}
		}
		sc.close();
		if (customers.isEmpty()) {
			System.out.println("가입한 회원이 없습니다.");
		} else {
			System.out.println("가입한 회원 리스트 목록");

			Iterator<String> iterator = customers.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(customers.get(key));
			}
		}
	}
}