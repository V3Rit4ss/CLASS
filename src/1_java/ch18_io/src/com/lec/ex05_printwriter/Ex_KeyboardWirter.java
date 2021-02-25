package com.lec.ex05_printwriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ex_KeyboardWirter {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String keepgoing, name , tel , birthday ,address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);
		do {
			try {
				System.out.print("회원가입 하실건가요? (Y/N)");
				keepgoing = keyboard.readLine();
				if(keepgoing.equalsIgnoreCase("n")) break;
				System.out.print("회원 이름.");
				name = keyboard.readLine();
				System.out.print("전화번호");
				tel = keyboard.readLine();
				System.out.print("생일 (mm-dd)?");
				birthday = keyboard.readLine();
				if(birthday.equals(todayStr)) {
					System.out.println(name+"님 생일이시네요, 축하드립니다.");
				}
				System.out.print("주소?");
				address = keyboard.readLine();
				
				customers.add(new Customer(name,tel,birthday,address));
			}catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
		}while(true);
		
		Writer writer =null;
		try {
			writer = new FileWriter("txtFile/Customer.txt", true);
			for(Customer c : customers) {
				System.out.print(c);
				writer.write(c.toString());
			}
			
			
			
		}catch (FileNotFoundException e) {
			System.out.println("파일 못찾음"+e.getMessage());
			
		}catch(IOException e) {
			System.out.println("쓰기 예외"+e.getMessage());
		}finally {
			try {
				if(writer != null) writer.close();
				if(keyboard != null) keyboard.close();
			}catch(Exception ignore) {
				System.out.println(ignore.getMessage());
			}
		}
	}
}
