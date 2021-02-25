package com.lec.condition;

public class Q2 {
    public static void main(String[] args) {
		int num1 = 27;
		int num2 = 32;
		int max;                                                // 여기에 넣으면 해결완료
		if(num1>num2){
			max = num1;  //{이 안에 변수를 선언하면 블럭 안에서만 쓸수있다.} // int max = ㅁㅁㅁ 를
		} else {
			max = num2;
		}
		System.out.println(max);
	    }

}
