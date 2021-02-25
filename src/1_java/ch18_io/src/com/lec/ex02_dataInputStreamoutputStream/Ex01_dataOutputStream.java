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
		DataOutputStream dos = null; //���� ��Ʈ��
		
		try {  //���� ��Ʈ���� �⺻��Ʈ���� ���ؼ��� ����.
			fos = new FileOutputStream("txtFile/dataFile.dat");  //�ؽ�Ʈ ���� �ƴ�;
			dos = new DataOutputStream(fos);
			//���� ���Ѿ���.
			
			dos.writeUTF("ȫ�浿"); //��Ʈ�� ����.
			dos.writeInt(2);//��Ʈ�� ����
			dos.writeDouble(95.9); //���� ����
			System.out.println("���� �Ϸ�");  //�ܼ� Ȯ��.   �ؽ�Ʈ�� Ȯ�κҰ�. �ڹٿ����� ��������.
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(dos != null) dos.close(); //1�� �ݰ�
				if(fos != null) fos.close(); //2�� �ݰ�
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
