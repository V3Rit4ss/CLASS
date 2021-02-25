package com.lec.ex05_printwriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ex_ScannerWriter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String keepgoing , name, tel, birthday, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Date today =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);
		do {
			System.out.print("ȸ������ �Ͻǰǰ���? (Y/N)?");
			keepgoing = sc.next();
			if(keepgoing.equalsIgnoreCase("n")) break;
			System.out.print("ȸ���̸�?");
			name = sc.next();
			System.out.print("��ȭ��ȣ?");
			tel = sc.next();
			System.out.print("����(mm-dd)?");
			birthday = sc.next();
			if(birthday.equals(todayStr)) {
				System.out.println(name+"�� �����̽ñ���, ���ϵ帳�ϴ�.");
			}
			System.out.print("�ּ� ?");
			sc.nextLine();
			address = sc.nextLine();
			customers.add(new Customer(name, tel, birthday, address));
			
		}while(true);
			Writer writer = null;
		try {
			writer = new FileWriter("txtFile/Customer.txt",true);
			for(Customer c: customers) {
				System.out.print(c);
				writer.write(c.toString());
			}
		}catch(FileNotFoundException e) {
			System.out.println("���� ��ã��"+e.getMessage());
		}catch(IOException e) {
			System.out.println("���� ����"+e.getMessage());
		}finally {
			try {
				if(writer != null) writer.close();
			}catch(Exception ignore) {
				System.out.println(ignore.getMessage());
				
			}
		}
	}
}
