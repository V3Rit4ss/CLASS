package com.lec.ex02_dataInputStreamoutputStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import java.util.Scanner;

//������ �Է� �ϴ°�
public class Ex03_ProductWrite {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null;
		String answer;
		Scanner sc = new Scanner(System.in);

		try {
			fos = new FileOutputStream("txtFile/product.dat", true);
			dos = new DataOutputStream(fos);

			while (true) {
				System.out.print("��� �Է� �Ͻðڽ��ϱ�? (Y/N).");
				answer = sc.nextLine();
				if (answer.equalsIgnoreCase("y")) {

					System.out.print("����� ��ǰ����?");

					dos.writeUTF(sc.nextLine());// ��Ʈ��

					System.out.print("��ǰ�� ������?");

					dos.writeInt(sc.nextInt());// ��Ʈ

					System.out.print("�� ��ǰ�� �� ������?");
					dos.writeInt(sc.nextInt());// ��Ʈ
					sc.nextLine();

					System.out.println("����Ϸ�");

				} else if (answer.equalsIgnoreCase("n")) {
					break;

				}
			}
//			if(!answer.equalsIgnoreCase("n")) {
//				System.out.println("���α׷��� ����˴ϴ�.");
//			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
