package com.lec.ex01_inputStreamOutputStream;
//1. 파일연다 2. 읽는다  3. 파일을 닫는다

import java.io.*;
public class Ex02_inputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/1.txt");
			byte[] bs = new byte[10];
			while(true) {
				
			//	int i = is.read(); 1byte
				int readByteCount = is.read(bs);
				if(readByteCount == -1) break;
				for(int i=0; i<readByteCount; i++) {
					System.out.print((char)bs[i]);
				}//for
			}//while
			
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			
			
			
		}finally {
			try {
				if(is != null) is.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	
	}
}
