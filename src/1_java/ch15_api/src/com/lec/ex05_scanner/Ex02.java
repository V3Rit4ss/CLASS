package com.lec.ex05_scanner;

import java.util.Scanner;

//cf. next() -> nextLine()버퍼 지우기. ->nextLine()이용
//1. nextLine() 이용 -> 2. next() 이용
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주소를 입력하세요");
		String address = sc.nextLine();
		System.out.println("입력하신 주소는 : "+address);
		System.out.print("이름을 입력하세요");
		String name = sc.nextLine(); //스페이스 포함
		System.out.println("입력하신 이름은 : "+name);
		System.out.print("나이를 입력하세여");
		int age = sc.nextInt();
		System.out.println("입력하신 나이는 : "+age);
	}
}
