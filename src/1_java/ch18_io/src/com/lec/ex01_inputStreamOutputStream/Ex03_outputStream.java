package com.lec.ex01_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try { // 1.파일을 연다 (스트링 객체를 생성)
			os = new FileOutputStream("txtFile/out.txt"); // 폴더가 없으면 실행 안댐.
			byte[] bs = { 'H', 'e', 'l', 'l', 'o', '\r', '\n', 'J', 'A', 'V', 'A' };
			for (int i = 0; i < bs.length; i++) {
				os.write(bs[i]); // 2.파일에 데이터 쓰기(반복)
			}
			
			System.out.println("성공"); //잘 되었는지 확인함.

		} catch (IOException e) { // 캐치절 순서 따져야함. 상위클래스가 맨위면 아래 상속클래스 실행 x

			System.out.println(e.getMessage()); // 하나로 합친 캐치절
		} finally {
			try {
				if (os != null)
					os.close(); // 3. 파일 닫기.
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
		

	}
}
