package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.print("나이를 입력하세여 : ");
		int age = sc.nextInt(); 
		System.out.println("입력하신 나이는 : "+age);
		System.out.print("이름을 입력 하세요 : ");
		String name = sc.next();  // 버퍼안   1. \n 데이터 들어감.     2.홍길동(기입.)\n 1번 버퍼데이터 버려지고 2번데이터가 들어감.
		System.out.println("입력하신 이름은 : "+name);  //띄어 쓰기같은경우 그다음공간에 준비중인 상태에서 스캐너 끝남.
		// 버퍼에 처음 나오는 \n은 무시하고 whiteSpece 나오기 전까지
		
		System.out.print("주소를 입력하세여 ");
		sc.nextLine();  //버퍼 지워주는 . (\n 때문에)
		String address = sc.nextLine(); // 버퍼에 \n이 나오는 앞까지 취함.
		System.out.println("입력하신 주소는 "+address);
		System.out.println("====================프로그램 끝.===================");
		
		
		
	}
}
