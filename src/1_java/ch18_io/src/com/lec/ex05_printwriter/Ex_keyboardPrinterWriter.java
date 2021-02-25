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
				System.out.print("회원 가입 하실건가요? (Y/N)");
				keepgoing = keyboard.readLine();
				if(keepgoing.equalsIgnoreCase("n")) break;
				System.out.print("회원 이름?");
				name = keyboard.readLine();
				System.out.print("전화번호?");
				tel = keyboard.readLine();
				System.out.print("생일(mm-dd)?");
				birthday = keyboard.readLine();
				if(birthday.equals(todayStr)) {
					System.out.println(name+"님 생일 이시군요, 축하드립니다.");
				}
				System.out.print("주소?");
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
			System.out.println("쓰기 예외"+e.getMessage());
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
