package com.lec.ex01_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

//Ʈ���� ���� ���� �ּ������θ� �����.
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i , j = 1;
		do {
			try {
				System.out.print("ù��° ���� ?");
				i = sc.nextInt();
				break;
			}catch(InputMismatchException e) {  //Exception �θ� Ŭ�����̴�  ArithmeticException ��� ���°� ����.
				
				System.out.println(e.getMessage());
				System.out.println("ù��° ���� ���ڸ� ���� ������.");
				sc.nextLine(); //���۸� ����� ����.  ?\n  �� ����.
			}
		}while(true);
		System.out.print("�ι�° ���� ?");
		try {
			
			j = sc.nextInt();
			System.out.println("i = "+i+", j = "+j );
			System.out.println("i * j = "+ (i*j) );
			//try {//Ʈ���̾ȿ� Ʈ���� �ֱ� ����.
			System.out.println("i / j = "+ (i/j) );
		}catch(ArithmeticException e){  //Exception �ְ� ���Ŭ�����̱⶧���� ������� �� �Ʒ���.
			
			System.out.println(e.getMessage()+"0���� ������ ���� �н�");
			
		}catch(InputMismatchException e) { //���ܹ߻��ÿ��� ����
			
			System.out.println(e.getMessage());
			System.out.println("�ι�° ���� �߸��Է��ؼ� 1�� �ʱ�ȭ ��");
			//j=1; ���⵵ ����.
		}catch (Exception e) {
			System.out.println(e.getMessage()+"���� �����ϱ�?");//Exception �ְ� ����Ŭ�����̱⶧���� ������� �� �Ʒ���.
		}
		System.out.println("i + j = "+ (i+j) );
		System.out.println("i - j = "+ (i-j) );
		System.out.println("DONE");
		sc.close();
		
	}
}
