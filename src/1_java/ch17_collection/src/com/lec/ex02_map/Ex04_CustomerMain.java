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
			System.out.print("ȸ�������� �Ͻðڽ��ϱ�? (Y/N) ");
			answer = sc.next(); // �ؽ�Ʈ�� �޴� �������� �޴� ����������� ���� �����ؼ� �ؾ���,
			if (answer.equalsIgnoreCase("n")) { // ȸ������ ����. y �� Y ���������ҷ���
				break;
			} else if (answer.equalsIgnoreCase("y")) {

				System.out.print("���� �Ͻ� ȸ������ �̸���?");
				name = sc.nextLine(); // �����̽��ٰ� �ȵ��ٸ� �ؽ�Ʈ ���ٸ� ����
				System.out.print("���� �Ͻ� ȸ������ ��ȭ��ȣ��?");
				phone = sc.nextLine();
				System.out.print("���� �Ͻ� ȸ������ �ּҴ�?");
				sc.nextLine(); // ���� ����� �뵵.
				address = sc.nextLine();
				customers.put(phone, new Customer(name, phone, address));

			}
		}
		sc.close();
		if (customers.isEmpty()) {
			System.out.println("������ ȸ���� �����ϴ�.");
		} else {
			System.out.println("������ ȸ�� ����Ʈ ���");

			Iterator<String> iterator = customers.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(customers.get(key));
			}
		}
	}
}