package com.lec.ex04_buffered;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

//Ű����κ��� ����� �����̸��� ����.(txtFile/2.txt)     
//while
//2.1 ����� ���� ������? ������ ������ �Է� �޽��ϴ�(Ű����κ���)  [���Ͼ��⸦ �ϱ������ x�Է�]
//2.2 Ű���忡�� �Է��� ������ ���Ϸ� ���ϴ�.
public class Ex03 {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Writer writer =null;
		System.out.print("����� �����̸���?");
		try {
			String filename = keyboard.readLine();
			writer = new FileWriter(filename, true); //������ �����߰� ������ ���λ���
			while(true) {
				System.out.println("����� ���� ������(������ ���� �� x)?");
				String content = keyboard.readLine();
				if(content.equalsIgnoreCase("x")) break;
				writer.write(content+"\r\n");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		}finally {
			try {
				if(writer != null) writer.close();
				if(keyboard != null) keyboard.close();
			}catch(Exception ignore) {
				System.out.println(ignore.getMessage());
			}
		}
	}
}
