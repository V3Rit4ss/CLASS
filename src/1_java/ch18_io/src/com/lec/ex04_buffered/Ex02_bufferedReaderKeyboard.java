package com.lec.ex04_buffered;

import java.io.BufferedReader;//������ ��Ʈ���̱⿡ ��Ȳ���°� ��ȯ���Ѿ���
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//Ű����� ���� ���� �̸��� �޾� �ش� ������ ���. ������ ���ٰ� ��� , ������ �ش� ������ ������ �б�
public class Ex02_bufferedReaderKeyboard {
	public static void main(String[] args) {
		BufferedReader keyboard 
			= new BufferedReader(new InputStreamReader(System.in));
		Reader reader = null;//�⺻��Ʈ��
		BufferedReader br = null; //���� ��Ʈ��
		System.out.print("�о�� ���� �̸�?");
		try {//txtFile/1.txt or  �������.
			String filename = keyboard.readLine();
			File file = new File(filename);  //�Է��� �����̸��� ���ϰ�ü.
			if(file.exists()) {
				reader = new FileReader(file);  //���� ���Yü ���鶧 ��Ʈ���� �־ �����̸��� �־ ����
				br = new BufferedReader(reader);
				
				while(true) {
					String line = br.readLine();
					if(line == null) break;
					System.out.println(line);
				}
			}else {
				System.out.println("�Է��Ͻ� ������ �������� �ʽ��ϴ�.");
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
