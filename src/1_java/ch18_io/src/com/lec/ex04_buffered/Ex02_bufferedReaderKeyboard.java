package com.lec.ex04_buffered;

import java.io.BufferedReader;//무조건 스트링이기에 상황에맞게 변환시켜야함
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//키보드로 부터 파일 이름을 받아 해당 파일을 출력. 없으면 없다고 출력 , 있으면 해당 파일의 내용을 읽기
public class Ex02_bufferedReaderKeyboard {
	public static void main(String[] args) {
		BufferedReader keyboard 
			= new BufferedReader(new InputStreamReader(System.in));
		Reader reader = null;//기본스트림
		BufferedReader br = null; //보조 스트림
		System.out.print("읽어올 파일 이름?");
		try {//txtFile/1.txt or  폴더경로.
			String filename = keyboard.readLine();
			File file = new File(filename);  //입력한 파일이름의 파일객체.
			if(file.exists()) {
				reader = new FileReader(file);  //파일 ㄱ갳체 만들때 스트링을 넣어도 파일이름을 넣어도 가능
				br = new BufferedReader(reader);
				
				while(true) {
					String line = br.readLine();
					if(line == null) break;
					System.out.println(line);
				}
			}else {
				System.out.println("입력하신 파일이 존재하지 않습니다.");
			}
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}finally {
			try {
				if(br != null) br.close();
				if(reader != null) reader.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
