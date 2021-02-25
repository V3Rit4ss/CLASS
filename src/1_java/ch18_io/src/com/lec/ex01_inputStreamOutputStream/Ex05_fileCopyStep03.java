package com.lec.ex01_inputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//���� ī��    : 1.��Ʈ�� ��ü ���� (2�� �ʿ� inputStream , outputStream) 2.�а� ����(�ݺ� ) 3.��Ʈ�� �ݱ�
public class Ex05_fileCopyStep03 { //���� ������Ʈ �ȿ� ������ ���� �ʿ�� ����.
	public static void main(String[] args) {
		FileInputStream is = null;    //InputStream ���Ͻ�Ʈ���̴� �̰Ŵ� �������.
		OutputStream os = null;
		try {  //  / : �ϳ��� ���� \\ �ΰ��� ����
			File originalFile = new File("txtFile\\495773655269005.jpg");//���� ��ü�� ����.
//			if(originalFile.exists()) {
//				System.out.println("���� ������");
//			}else {
//				System.out.println("���� �̸��� �߸� �Ǿ����ϴ� .  �������� �ʽ��ϴ�.");
//			}
			is = new FileInputStream(originalFile); //input ��ü (�Է�)
			os = new FileOutputStream("txtFile/jigu.jpg");  // output ��ü (���)  //�Ȱ����� ������ ���.
			int cnt =0;
//			int length = 0;  2�Ⱑ ������.   �̷��� �ϸ� ����ȭ�� ���ܼ� ���������� �ִ�.
//			if(originalFile.length()>2100000000) {
//				length = 2100000000;
//			}else {
//				length = (int)originalFile.length();
//			}
			//byte[] bs = new byte[(int)originalFile.length()]; ���� ��ü�� ũ�⸦ �������� ��Ƽ� �ϸ� �������� ũ��� �а� ���� ��.
			
			
			byte[] bs = new byte[(int)originalFile.length()];  //1kb�� �� �迭�� �о� ���̴� ����  //int �뷮���� �Ѿ�� �ȴ�.
			while(true) {
				++cnt;
		//		System.out.println(cnt); �ѷ��� ������ ��û �ɸ�.
				int readByteCount = is.read(bs); //1����Ʈ �б�   => 1024����Ʈ�� �а� �Ϸ����Ѵ�
				if(readByteCount == -1) break;   
				os.write(bs, 0, readByteCount); // bs �迭�� 0�� �ε������� readByteCount ����Ʈ ��ŭ�� ���Ͽ� ����
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
