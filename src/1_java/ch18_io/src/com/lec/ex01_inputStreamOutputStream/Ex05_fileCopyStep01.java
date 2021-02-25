package com.lec.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//���� ī��    : 1.��Ʈ�� ��ü ���� (2�� �ʿ� inputStream , outputStream) 2.�а� ����(�ݺ� ) 3.��Ʈ�� �ݱ�
public class Ex05_fileCopyStep01 { //���� ������Ʈ �ȿ� ������ ���� �ʿ�� ����.
	public static void main(String[] args) {
		FileInputStream is = null;    //InputStream ���Ͻ�Ʈ���̴� �̰Ŵ� �������.
		OutputStream os = null;
		try {  //  / : �ϳ��� ���� \\ �ΰ��� ����
			is = new FileInputStream("txtFile\\495773655269005.jpg"); //input ��ü (�Է�)
			os = new FileOutputStream("txtFile/jigu.jpg");  // output ��ü (���)
			int cnt =0;
			while(true) {
				++cnt;
		//		System.out.println(cnt); �ѷ��� ������ ��û �ɸ�.
				int i = is.read(); //1����Ʈ �б�
				if(i == -1) break;
				os.write(i);
			}
			System.out.println(cnt+"�� �ݺ��� ���� �� ���� ���� ����");
		}catch(FileNotFoundException e) {
			System.out.println("�����̳� ������ �� ã��"+e.getMessage());
		} catch (IOException e) {
			System.out.println("�а� ���� ���ܳ�"+e.getMessage());
		}finally {
			
			try {
				if(is != null) is.close();
				if(os != null) os.close();  //��Ʈ���� ���� �ݴ�������� Ŭ���� �������.
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
}
