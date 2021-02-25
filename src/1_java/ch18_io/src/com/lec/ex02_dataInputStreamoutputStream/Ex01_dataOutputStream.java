package com.lec.ex02_dataInputStreamoutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//
public class Ex01_dataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null; //보조 스트림
		
		try {  //보조 스트림은 기본스트림을 통해서만 생성.
			fos = new FileOutputStream("txtFile/dataFile.dat");  //텍스트 파일 아님;
			dos = new DataOutputStream(fos);
			//순서 지켜야함.
			
			dos.writeUTF("홍길동"); //스트링 저장.
			dos.writeInt(2);//인트값 저장
			dos.writeDouble(95.9); //더블값 저장
			System.out.println("저장 완료");  //콘솔 확인.   텍스트로 확인불가. 자바에서만 볼수있음.
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(dos != null) dos.close(); //1번 닫고
				if(fos != null) fos.close(); //2번 닫고
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
