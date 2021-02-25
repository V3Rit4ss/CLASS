package com.lec.ex05_printwriter;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex01 {
	public static void main(String[] args) {
		PrintWriter printWriter = null;
		OutputStream os = null;
		Writer writer = null;
		try {
			//printWriter = new PrintWriter("txtFile/out.txt");  �̰͵� ����.  2����Ʈ
//			os = new FileOutputStream("txtFile/out.txt");//
//			printWriter = new PrintWriter(os);//1����Ʈ.
//			writer = new FileWriter("txtFile/out.txt");
//			printWriter = new PrintWriter("txtFile/out.txt");
			printWriter = new PrintWriter("txtFile/out.txt");  //��Ʈ�� ��ü ����
			
			System.out.println("�ȳ��ϼ���\r\n �ݰ����ϴ�."); //�ܼ�â�� ���̰�
			printWriter.println("�ȳ��ϼ���\r\n�ݰ����ϴ�."); //���Ͽ� �Ѹ��°�
			//
			System.out.print("���� �ڵ� �ȵ� ����\n");
			printWriter.print("���� �ȵ� ����\r\n");
			//
			System.out.printf("%5s %3d %3d %5.1f\n","ȫ�浿",99,88,88.5);
			printWriter.printf("%5s %3d %3d %5.1f\r\n","ȫ�浿",99,88,88.5);
			//
			System.out.printf("%5s %3d %3d %5.1f\n","��浿",100,70,80.5);
			printWriter.printf("%5s %3d %3d %5.1f\r\n","��浿",100,70,80.5);
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(printWriter != null) printWriter.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
