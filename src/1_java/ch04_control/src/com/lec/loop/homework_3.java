package com.lec.loop;

import java.util.Scanner;

public class homework_3 {
	public static void main(String[] args) {
		int ai, you;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("����(0), ����(1), ��(2) �� �ϳ��� ���ÿ�. ������ �����ÿ� -1) : ");
			you = sc.nextInt();
			if(you== -1) {
				break;
			}
			ai = (int)(Math.random()*3);
			if(you > 2 || you < -1) {
				System.out.println("����(0), ����(1), ��(2) ���� �߿��� �� ���� �Ͻÿ�.");
			}else if((you+2)%3==ai) {
				System.out.println("�Է� �� "+(you==0? "����":you==1? "����" : "��"));
				System.out.println("AI ��"+(ai==0? "����":ai==1? "����":"��"));
				System.out.println(" ����� �̰���ϴ�. ");
			}else if(you == ai){
				System.out.println("�Է� �� "+(you==0?"����":you==1? "����":"��"));
				System.out.println("AI ��"+(ai==0? "����":ai==1?"����":"��"));
				System.out.println(" AI �� ������ ���ҽ��ϴ�. ");
			}else {
				System.out.println("�Է� �� "+(you==0?"����":you==1? "����":"��"));
				System.out.println("AI ��"+(ai==0? "����":ai==1?"����":"��"));
				System.out.println(" ����� �����ϴ�. ");
			}//if
		} sc.close();
		System.out.println("See U next time");
	}//main
}//class
