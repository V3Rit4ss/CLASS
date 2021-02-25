package com.lec.ex;

public class Ex_02 {
	public static void main(String[] args) {
		int n1 =10;
		int n2 = n1++; // n1 : 11 , n2 : 10
		System.out.printf("1. n1=%d, n2=%d\n", n1, n2);
		// 1시점 : 10 
		//++n1;  // 하나 증가 해라 (++)
		// 2시점 : 11   바로 앞에서 바뀜
		//n1++;
		// 3시점 : 12   다음 템포에 바뀜 [한마디로 ++n은 바로 연산하고 값이 나오고, n++은 계산 '전' 인  n값이 나옴 하지만 그림자는 연산한값이 나와있음.
		int n3 = 10;
		System.out.printf("2. n3 = %d\n", n3--);
		System.out.printf("3. n3 = %d\n", n3);
		int temp = 10;
		System.out.printf("4. %d %d %d %d\n", 
						temp++, ++temp, temp--, temp--);
		//				10		12		12		11
		System.out.printf("5. 최종 temp = %d\n", temp);
	}
}
