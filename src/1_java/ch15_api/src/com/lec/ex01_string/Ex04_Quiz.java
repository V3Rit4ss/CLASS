package com.lec.ex01_string;

import java.util.Scanner;

//I: checkIn ("�ݳ��Ǿ����ϴ�.") ��� , O : checkOut("���� �Ǿ����ϴ�.") ���
//x : ����.
public class Ex04_Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fn;
		while(true) { //ȭ�Ϲ� ���� ���������.
			System.out.print("I : checkIn, O : checkOut, x : Exit ?");
			fn = sc.next();
			if(fn.equalsIgnoreCase("x")) {
				break;
			}else if(fn.equalsIgnoreCase("i")) {//(fn.equals("i")|| fn.equals("I"))
				System.out.println("�ݳ��Ǿ����ϴ�.");
			}else if(fn.equalsIgnoreCase("o")) {
				System.out.println("����Ǿ����ϴ�");
			}
		}
//		do { ��ȭ�Ϲ����� ���������.
//			System.out.print("I : checkIn, O : checkOut, x : Exit ?");
//			fn = sc.next();
//			if(fn.equalsIgnoreCase("i")) {//(fn.equals("i")|| fn.equals("I"))
//				System.out.println("�ݳ��Ǿ����ϴ�.");
//			}else if(fn.equalsIgnoreCase("o")) {
//				System.out.println("����Ǿ����ϴ�");
//			}
//		}while(!fn.equalsIgnoreCase("x")); //!fn �ݴ��� �ǹ� : x �� fn �� ���� ������ 
//		System.out.println("DONE");
	}
}
