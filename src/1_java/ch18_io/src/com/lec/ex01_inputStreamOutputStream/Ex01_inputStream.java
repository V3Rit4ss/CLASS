package com.lec.ex01_inputStreamOutputStream;//여기서는 1바이트.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1. 파일을 연다(스트링 객체 생성) 2.데이터를 읽는다(1바이트 또는 2바이트로 읽는다.)  3.파일을 닫는다.
public class Ex01_inputStream {
	public static void main(String[] args) {
		
		InputStream is =null;    //try-catch 절 전에 스트링 변수 선언해야한다
		
		
		try {  //절대경로를 넣어도 댐
			is = new FileInputStream("txtFile/1.txt");  //1단계 파일 열기//실제로 있는 파일이름을 넣어야한다.
			//2단계 데이터 읽기(1바이트 단위로 반복)
			while(true) {
				int i = is.read(); //1바이트  읽기
				if(i == -1) 
					break;
				//System.out.println((char)i  +"-아스키코드 : "+i);
				System.out.print((char)i);  //텍스트 파일 내용을 그대로 보여준다.
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			
			
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			
			
		}finally {                     //3단계 파일 닫기
			
			
			
			try {
				if(is != null) is.close();
			} catch (IOException e) {}
				

			
			
		}//try-catch-finally
		
	}
}//main
