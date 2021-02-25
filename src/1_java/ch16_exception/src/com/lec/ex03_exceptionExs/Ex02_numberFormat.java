package com.lec.ex03_exceptionExs;
//trim() 좌우 스페이스바 삭제.
public class Ex02_numberFormat {
	public static void main(String[] args) {
		String str = "";
		int i=0;
		try {
			 i = Integer.parseInt(str.trim());
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
			
		}
		System.out.println(i);
	}
}
