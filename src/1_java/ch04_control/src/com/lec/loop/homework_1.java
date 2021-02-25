package com.lec.loop;
//제출 하기
public class homework_1 {
	public static void main(String[] args) { // 최대한 하고 안돼면 주말까지 내기.
		int i = 1;
		int su = 0;
		while (i <= 20) {
			if (i %2 != 0 && i%3!= 0) {
				su += i;
			}//if      // 1번 오류값이 다 나온뒤에 while 블록안에서 i=1 를 증가시키는 값을 넣는다 [i++] =>은 한템포 늦게 변형된다. 
			i++;    // 1.오류 변수 선언한 1값이 와일값에 true -> 이프문 -> true -> [증가 안한 1값이 계속 돌기때문] 
		}//while
		System.out.printf("2와3의 배수가 아닌 수의 합 :"+su);
	}//main
}//class