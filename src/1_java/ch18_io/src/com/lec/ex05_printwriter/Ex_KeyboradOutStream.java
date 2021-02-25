package com.lec.ex05_printwriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.omg.CORBA.ExceptionList;

public class Ex_KeyboradOutStream {
	public static void main(String[] args) {
		BufferedReader keyborad = new BufferedReader(new InputStreamReader(System.in));
		String keepgoing, name , tel , birthday, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);
		
		do {
			try {
				System.out.print("회원 가입을 하실건가요? (Y/N)");
				keepgoing = keyborad.readLine();
				if(keepgoing.equalsIgnoreCase("n")) break;
				System.out.print("회원 이름 ?");
				name = keyborad.readLine();
				System.out.print("전화번호");
				tel = keyborad.readLine();
				System.out.print("생일(mm-dd)?");
				birthday = keyborad.readLine();
				if(birthday.equals(todayStr)) {
					System.out.println(name+"님 생일 이시군요. 생일 축하합니다.");
				}
				System.out.print("주소?");
				address = keyborad.readLine();
				customers.add(new Customer(name, tel, birthday, address));
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while(true);
		OutputStream os = null;
			try {
				os = new FileOutputStream("txtFile/Customer.txt", true);
				for(Customer c : customers) {
					byte[] bs = c.toString().getBytes();
					System.out.print(c);
					os.write(bs);
				}
			}catch (FileNotFoundException e) {
				System.out.println("파일을 못찾음"+e.getMessage());
			}catch (IOException e) {
				System.out.println("쓰기 예외"+e.getMessage());
			}finally {
				try {
					if(os != null) os.close();
					if(keyborad != null) keyborad.close();
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
	}
}
