package com.lec.ex03_writerReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt");
			String str = "�ȳ��ϼ���\r\n�����ٶ󸶹ٻ������īŸ����"; //\r\n ���� ����������� �ؽ�Ʈ�� �����Ѱ��� �ҷ����� ����ֱ⶧���� �־���.
			char[] st = str.toCharArray(); //��Ʈ���� char�迭��.
		//	writer.write(st);�Ѵ� ����.
			writer.write(str);
			String str1 = "�Ƥ���������������";
			writer.write(str1);  //����� (�߰�)�Ǽ� ����
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		}finally {
			try {
				if(writer!=null) writer.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
