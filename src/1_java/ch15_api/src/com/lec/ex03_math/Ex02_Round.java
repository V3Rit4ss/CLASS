package com.lec.ex03_math;
//
public class Ex02_Round {
	public static void main(String[] args) {
		//�ݿø�   69.56�� �ݿø��غ���
		System.out.println("�Ҽ������� �ݿø�, �ø�, ����");
		System.out.println("9.12�� �ø� : "+(int)Math.ceil(9.12));//�⺻�� ������  (int)�� ������ ������.
		System.out.println("9.12�� �ݿø� : "+Math.round(9.12));
		System.out.println("9.12�� ���� : "+(int)Math.floor(9.12));
		System.out.println("�Ҽ��� '���ڸ�'���� �ݿø�,�ø�,����"); // (9.15*10)/10 �ڹٿ����� �̷����ؾ���.
		System.out.println("9.15�� �ø� : "+Math.ceil(9.15*10)/10);
		System.out.println("9.15�� �ݿø� : "+Math.round(9.15*10)/10.0);  //���� ��ü�� ��Ʈ�� 10.0  '.0' �� �߰�. 
		System.out.println("9.15�� ���� : "+Math.floor(9.15*10)/10);
		
		
		System.out.println("���� �ڸ����� �ݿø� , �ø�, ����");
		System.out.println("85�� �ø� (90): "+Math.ceil(85/10.0)*10);
		System.out.println("85�� �ݿø�(90) : "+Math.round(85/10.0)*10);
		System.out.println("85�� ����(80) : "+Math.floor(85/10.0)*10);
	}
}
