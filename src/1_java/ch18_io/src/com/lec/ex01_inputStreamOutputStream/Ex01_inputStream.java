package com.lec.ex01_inputStreamOutputStream;//���⼭�� 1����Ʈ.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1. ������ ����(��Ʈ�� ��ü ����) 2.�����͸� �д´�(1����Ʈ �Ǵ� 2����Ʈ�� �д´�.)  3.������ �ݴ´�.
public class Ex01_inputStream {
	public static void main(String[] args) {
		
		InputStream is =null;    //try-catch �� ���� ��Ʈ�� ���� �����ؾ��Ѵ�
		
		
		try {  //�����θ� �־ ��
			is = new FileInputStream("txtFile/1.txt");  //1�ܰ� ���� ����//������ �ִ� �����̸��� �־���Ѵ�.
			//2�ܰ� ������ �б�(1����Ʈ ������ �ݺ�)
			while(true) {
				int i = is.read(); //1����Ʈ  �б�
				if(i == -1) 
					break;
				//System.out.println((char)i  +"-�ƽ�Ű�ڵ� : "+i);
				System.out.print((char)i);  //�ؽ�Ʈ ���� ������ �״�� �����ش�.
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			
			
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			
			
		}finally {                     //3�ܰ� ���� �ݱ�
			
			
			
			try {
				if(is != null) is.close();
			} catch (IOException e) {}
				

			
			
		}//try-catch-finally
		
	}
}//main
