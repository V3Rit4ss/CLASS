package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_05CustomerMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name , phone ,address ;
		ArrayList<Customer> customers = new ArrayList<Customer>();  //   =>  ���� �迭. Customer[] cs = new Customer[10];
		do {
			System.out.print("ȸ�������� �Ͻðڽ��ϱ�? (Y/N) ");
			answer = sc.next();   //�ؽ�Ʈ�� �޴� �������� �޴� ����������� ���� �����ؼ� �ؾ���,
			if(answer.equalsIgnoreCase("y")) {  //ȸ������ ����.  y �� Y ���������ҷ���
				System.out.print("���� �Ͻ� ȸ������ �̸���?");
				name = sc.next();  //�����̽��ٰ� �ȵ��ٸ� �ؽ�Ʈ ���ٸ� ����
				System.out.print("���� �Ͻ� ȸ������ ��ȭ��ȣ��?");
				phone = sc.next();
				System.out.print("���� �Ͻ� ȸ������ �ּҴ�?");
				sc.nextLine(); // ���� ����� �뵵.
				address = sc.nextLine();
//				Customer temp = new Customer(name, phone ,address);
//				customers.add(temp); �̷��� ���ϰ�
				customers.add(new Customer(name, phone, address));  //����
			}else if(answer.equalsIgnoreCase("n")) {
				break;
			}
			
		}while(!answer.equalsIgnoreCase("n"));  //true �� �ص� ����� ������ �������� ������..
			System.out.println("������ ȸ�� ����Ʈ ���");
			for(Customer customer : customers) {//Ȯ��for
				System.out.println(customer);
			}
//		for(int idx=0; idx<customers.size(); idx++) {//�Ϲ� for
//			System.out.println(customers.get(idx));
//		}
//		
		
		
	}//class
}//main
