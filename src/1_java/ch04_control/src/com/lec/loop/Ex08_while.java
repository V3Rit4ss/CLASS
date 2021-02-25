package com.lec.loop;
//i 가 1일때 누적합은 x 이다 (i가 1~10까지)
public class Ex08_while {
	public static void main(String[] args) {
		int i=1;     //화일 시작전에 초기화해주자
		int sum =0;
		while(i<=10) {
			sum += i; //sum = sum + i;
//			System.out.println("i가 "+i+"일 때 누적합은 "+sum+"이다"); 이렇게 해도 되지만 복잡하고 가독성에 문제가 있기에 아래 처럼 하는게 가독성에 더 좋다.
			System.out.printf("i가 %d일 때 누적합은 %d이다 \n",i ,sum);
			++i;
		}
//		for(int j=1 ; j<=10 ; j++) {
//			System.out.printf("i가 %d일 때 누적합은 %d이다 \n",i ,sum);
//		}
	}
}