package com.lec.ex05_printwriter;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Ex_keyboardPrinterWriter {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String keepgoing , name , tel, birthday, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);
		do {
			try {
				System.out.print("ȸ�� ���� �Ͻǰǰ���? (Y/N)");
				keepgoing = keyboard.readLine();
				if(keepgoing.equalsIgnoreCase("n")) break;
				System.out.print("ȸ�� �̸�?");
				name = keyboard.readLine();
				System.out.print("��ȭ��ȣ?");
				tel = keyboard.readLine();
				System.out.print("����(mm-dd)?");
				birthday = keyboard.readLine();
				if(birthday.equals(todayStr)) {
					System.out.println(name+"�� ���� �̽ñ���, ���ϵ帳�ϴ�.");
				}
				System.out.print("�ּ�?");
				address = keyboard.readLine();
				customers.add(new Customer(name, tel, birthday, address));
			}catch(IOException e) {
				System.out.println(e.getMessage());
				
			}
		}while(true);
		OutputStream os = null;
		PrintWriter printwriter = null;
		try {
			os = new FileOutputStream("txtFile/Customer.txt", true);
			printwriter = new PrintWriter(os);
			for(Customer c : customers) {
				System.out.print(c);
				printwriter.print(c.toString());
			}
		}catch (IOException e) {
			System.out.println("���� ����"+e.getMessage());
		}finally {
			try {
				if(printwriter != null) printwriter.close();
				if(os != null) os.close();
				if(keyboard != null) keyboard.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
}
