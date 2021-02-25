package com.lec.ex01_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_outputStream {
	public static void main(String[] args) {
		
		OutputStream os = null;
		try {							//true �߰��� : ���Ͽ�  append(�����߰�.) , ������ �����
			 os = new FileOutputStream("txtFile/out.txt",true);  //1.��Ʈ�� ��ü����
			 String str = "��� �� �ȳ��� �ʿ��� �ñ�\r\n";
			 byte[] bs =str.getBytes(); //��Ʈ���� ����Ʈ�迭��.
			 os.write(bs); //2. ���� ����  (�ѹ��� ���¹��.)
		} catch (FileNotFoundException e) {
			
			System.out.println("������ ��ã��"+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("���� ���� ����"+e.getMessage());
		}finally {
			try {
				if(os != null) os.close();
			}catch (Exception e) {}
				
				
			}
		}
	}

