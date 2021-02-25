package com.lec.ex01_inputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//파일 카피    : 1.스트링 객체 생성 (2개 필요 inputStream , outputStream) 2.읽고 쓰기(반복 ) 3.스트링 닫기
public class Ex05_fileCopyStep03 { //굳이 프로젝트 안에 파일을 받을 필요는 없다.
	public static void main(String[] args) {
		FileInputStream is = null;    //InputStream 파일스트림이던 이거던 상관없다.
		OutputStream os = null;
		try {  //  / : 하나만 쓰던 \\ 두개를 쓰던
			File originalFile = new File("txtFile\\495773655269005.jpg");//파일 객체를 만듬.
//			if(originalFile.exists()) {
//				System.out.println("파일 존재함");
//			}else {
//				System.out.println("파일 이름이 잘못 되었습니다 .  존재하지 않습니다.");
//			}
			is = new FileInputStream(originalFile); //input 객체 (입력)
			os = new FileOutputStream("txtFile/jigu.jpg");  // output 객체 (출력)  //똑같은거 있으면 덮어씀.
			int cnt =0;
//			int length = 0;  2기가 넘을때.   이렇게 하면 과부화가 생겨서 느려질수도 있다.
//			if(originalFile.length()>2100000000) {
//				length = 2100000000;
//			}else {
//				length = (int)originalFile.length();
//			}
			//byte[] bs = new byte[(int)originalFile.length()]; 파일 자체의 크기를 기준으로 삼아서 하면 그파일의 크기로 읽고 쓰고 함.
			
			
			byte[] bs = new byte[(int)originalFile.length()];  //1kb씩 이 배열에 읽어 들이는 목적  //int 용량보다 넘어가면 안댐.
			while(true) {
				++cnt;
		//		System.out.println(cnt); 뿌려서 보려면 엄청 걸림.
				int readByteCount = is.read(bs); //1바이트 읽기   => 1024바이트씩 읽게 하려고한다
				if(readByteCount == -1) break;   
				os.write(bs, 0, readByteCount); // bs 배열에 0번 인덱스부터 readByteCount 바이트 만큼만 파일에 쓰기
			}
			System.out.println(cnt+"번 반복문 실행 후 파일 복사 성공");
		}catch(FileNotFoundException e) {
			System.out.println("파일이나 폴더를 못 찾음"+e.getMessage());
		} catch (IOException e) {
			System.out.println("읽고 쓸때 예외남"+e.getMessage());
		}finally {
			
			try {
				if(is != null) is.close();
				if(os != null) os.close();  //스트림을 만든 반대방향으로 클로즈 해줘야함.
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
}
