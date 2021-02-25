package com.lec.ex01_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try { // 1.������ ���� (��Ʈ�� ��ü�� ����)
			os = new FileOutputStream("txtFile/out.txt"); // ������ ������ ���� �ȴ�.
			byte[] bs = { 'H', 'e', 'l', 'l', 'o', '\r', '\n', 'J', 'A', 'V', 'A' };
			for (int i = 0; i < bs.length; i++) {
				os.write(bs[i]); // 2.���Ͽ� ������ ����(�ݺ�)
			}
			
			System.out.println("����"); //�� �Ǿ����� Ȯ����.

		} catch (IOException e) { // ĳġ�� ���� ��������. ����Ŭ������ ������ �Ʒ� ���Ŭ���� ���� x

			System.out.println(e.getMessage()); // �ϳ��� ��ģ ĳġ��
		} finally {
			try {
				if (os != null)
					os.close(); // 3. ���� �ݱ�.
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
		

	}
}
