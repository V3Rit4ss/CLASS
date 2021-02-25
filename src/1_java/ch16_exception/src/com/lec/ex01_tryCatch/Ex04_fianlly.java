package com.lec.ex01_tryCatch;

public class Ex04_fianlly {
	public static void main(String[] args) {
		int[] iArr =  {0,1,2};
		for(int i=0; i<=iArr.length; i++) {
			try {
			System.out.println("iArr["+i+"] = "+iArr[i]);
			}catch(ArrayIndexOutOfBoundsException e) {  //한번이라도 실행시켰으면 콘솔창에있는 걸 복붙. or Exception 쓰기.
				System.out.println("예외메세지 : "+e.getMessage());
			}finally{
				System.out.println("try로 실행후에도 catch문 실행후에도 여기는 결국 실행");
			}
		}
		System.out.println("프로그램 끝.");
	}
}
