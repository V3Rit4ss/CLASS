package com.lec.ex05_printwriter;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex01 {
	public static void main(String[] args) {
		PrintWriter printWriter = null;
		OutputStream os = null;
		Writer writer = null;
		try {
			//printWriter = new PrintWriter("txtFile/out.txt");  이것도 가능.  2바이트
//			os = new FileOutputStream("txtFile/out.txt");//
//			printWriter = new PrintWriter(os);//1바이트.
//			writer = new FileWriter("txtFile/out.txt");
//			printWriter = new PrintWriter("txtFile/out.txt");
			printWriter = new PrintWriter("txtFile/out.txt");  //스트림 객체 생성
			
			System.out.println("안녕하세요\r\n 반갑습니다."); //콘솔창에 보이게
			printWriter.println("안녕하세여\r\n반갑습니다."); //파일에 뿌리는거
			//
			System.out.print("개행 자동 안될 예정\n");
			printWriter.print("개행 안될 예정\r\n");
			//
			System.out.printf("%5s %3d %3d %5.1f\n","홍길동",99,88,88.5);
			printWriter.printf("%5s %3d %3d %5.1f\r\n","홍길동",99,88,88.5);
			//
			System.out.printf("%5s %3d %3d %5.1f\n","김길동",100,70,80.5);
			printWriter.printf("%5s %3d %3d %5.1f\r\n","김길동",100,70,80.5);
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(printWriter != null) printWriter.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
