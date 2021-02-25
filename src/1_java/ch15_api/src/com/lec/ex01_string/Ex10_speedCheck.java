package com.lec.ex01_string;
//��Ƽ�� ������ �ӵ� ���̰� �󸶳� ����?
//https://www.epochconverter.com/clock 
public class Ex10_speedCheck {
	public static void main(String[] args) {
		String str = "A";
		//���۽ð� ����
		long start = System.currentTimeMillis();
		for(int i = 0; i<50000 ; i++) {
			str = str.concat("a"); //1.a  2.aa 3.aaa ~ 50000. aaaaa~~
		}
		//�� �ð� ����.
		long end = System.currentTimeMillis();
		System.out.println("��Ʈ�� ���� �ð� : "+(end-start));
		
		StringBuffer strBuff = new StringBuffer("A");
		start = System.currentTimeMillis();
		for(int i =0; i<50000 ; i++) {
			strBuff.append("a");
		}
		
		end = System.currentTimeMillis();
		System.out.println("Stringbuff ���� �ð� : "+(end-start));
		
		StringBuilder strBuil = new StringBuilder("A");
		start = System.currentTimeMillis();
		for(int i = 0; i<50000; i++) {
			strBuil.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuilder ���� �ð� : "+(end-start));
	}
}
