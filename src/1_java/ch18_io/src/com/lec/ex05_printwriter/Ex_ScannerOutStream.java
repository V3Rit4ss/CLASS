package com.lec.ex05_printwriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ex_ScannerOutStream {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String keepgoing , name , tel , birthday , address ;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);
		do {
			System.out.print("회원 가입 하실건가요? (Y/N)?");
			keepgoing = sc.next();
			if(keepgoing.equalsIgnoreCase("n")) break;
			System.out.print("회원 이름?");
			name = sc.next();
			System.out.print("전화번호?");
			tel = sc.next();
			System.out.print("생일(mm-dd) ? ");
			birthday = sc.next();
			System.out.print("주소?");
			sc.nextLine();
			address = sc.nextLine();
			if(birthday.equals(todayStr)) {
				System.out.println(name+"님 생일 이시군요, 축하드립니다.");
			}
			customers.add(new Customer(name, tel , birthday , address));
		}while(true);
		OutputStream os = null;
			try {
				os = new FileOutputStream("txtFile/Customer.txt",true);
				for(Customer c: customers) {
					byte[] bs = c.toString().getBytes();
					System.out.print(c);
					os.write(bs);
				}
			}catch (FileNotFoundException e) {
				System.out.println("파일 못찾음"+e.getMessage());
			}catch (IOException e) {
				System.out.println("쓰기 예외"+e.getMessage());
			}finally {
				try {
					if(os != null) os.close();
				}catch (Exception ignore) {
					System.out.println(ignore.getMessage());
				}
			}
	}
}
