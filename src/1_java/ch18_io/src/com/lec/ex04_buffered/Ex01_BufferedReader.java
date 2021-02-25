package com.lec.ex04_buffered;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
//한줄씩 한줄씩 읽는. \n 기준으로
public class Ex01_BufferedReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
		reader = new FileReader("txtFile/2.txt");
		br  =  new  BufferedReader(reader);
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			System.out.println(line);
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
			
		}finally {
			try {
				if(br != null)br.close();
				if(reader != null)reader.close();
			}catch(Exception e) {
				
			}
		}
	}
}
