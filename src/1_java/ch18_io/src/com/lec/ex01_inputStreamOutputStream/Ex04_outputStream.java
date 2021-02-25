package com.lec.ex01_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_outputStream {
	public static void main(String[] args) {
		
		OutputStream os = null;
		try {							//true 추가시 : 파일에  append(내용추가.) , 없으면 덮어쓰기
			 os = new FileOutputStream("txtFile/out.txt",true);  //1.스트링 객체생성
			 String str = "모두 다 안녕이 필여한 시국\r\n";
			 byte[] bs =str.getBytes(); //스트링을 바이트배열로.
			 os.write(bs); //2. 파일 쓰기  (한번에 쓰는방법.)
		} catch (FileNotFoundException e) {
			
			System.out.println("파일을 못찾음"+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("파일 쓰기 오류"+e.getMessage());
		}finally {
			try {
				if(os != null) os.close();
			}catch (Exception e) {}
				
				
			}
		}
	}

