package com.lec.ex03_writerReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt");
			String str = "안녕하세요\r\n가나다라마바사아자차카타파하"; //\r\n 빼도 상관은없지만 텍스트로 저장한것을 불러오면 들어있기때문에 넣었다.
			char[] st = str.toCharArray(); //스트링을 char배열로.
		//	writer.write(st);둘다 가능.
			writer.write(str);
			String str1 = "아ㅏㅏㅏㅏㅏㅏㅏㅏ";
			writer.write(str1);  //어펜드 (추가)되서 들어간다
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		}finally {
			try {
				if(writer!=null) writer.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
