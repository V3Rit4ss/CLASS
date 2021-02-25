package com.lec.ex02_dataInputStreamoutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_DataInputStream {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(fis);
			//읽을때도 아웃풋 때 했던 순서대로 해야함.
			String name = dis.readUTF();  //순서 바뀌면 캐치절로 빠짐.
			int grade = dis.readInt();
			double score = dis.readDouble();
			System.out.println("파일로 부터 입력받은 값은 : "+name+"\t"+grade+"\t"+score);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(dis != null) dis.close();
				if(fis != null) fis.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}//close
		}//try-catch-finally
	}//main
}//class
