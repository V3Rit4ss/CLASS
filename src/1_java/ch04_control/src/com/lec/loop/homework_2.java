package com.lec.loop;
//       ���� �ϱ�.
public class homework_2 {
	public static void main(String[] args) {
		for(int i=1 ; i < 7 ; i++ ) {
			for(int j =1; j < 7; j++) {
				if (i +j == 6) {
					System.out.printf("("+ i + "," + j +")");
				}
			}
		}

	}
}