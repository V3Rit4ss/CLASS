package com.lec.ex02_dataInputStreamoutputStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import java.util.Scanner;

//데이터 입력 하는곳
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
				System.out.print("재고를 입력 하시겠습니까? (Y/N).");
				answer = sc.nextLine();
				if (answer.equalsIgnoreCase("y")) {

					System.out.print("재고의 제품명은?");

					dos.writeUTF(sc.nextLine());// 스트링

					System.out.print("제품의 가격은?");

					dos.writeInt(sc.nextInt());// 인트

					System.out.print("현 제품의 총 수량은?");
					dos.writeInt(sc.nextInt());// 인트
					sc.nextLine();

					System.out.println("저장완료");

				} else if (answer.equalsIgnoreCase("n")) {
					break;

				}
			}
//			if(!answer.equalsIgnoreCase("n")) {
//				System.out.println("프로그램이 종료됩니다.");
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
