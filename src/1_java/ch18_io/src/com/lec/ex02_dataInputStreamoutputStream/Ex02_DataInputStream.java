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
			//�������� �ƿ�ǲ �� �ߴ� ������� �ؾ���.
			String name = dis.readUTF();  //���� �ٲ�� ĳġ���� ����.
			int grade = dis.readInt();
			double score = dis.readDouble();
			System.out.println("���Ϸ� ���� �Է¹��� ���� : "+name+"\t"+grade+"\t"+score);
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
