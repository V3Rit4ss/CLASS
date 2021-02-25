package com.lec.ex06_wrapper;
//가변인자 함수   인자==매개변수  [매개변수가 바뀌는]
public class Ex02 {
	public static void main(String[] args) {
		int total = valueSum("10","20");
		System.out.println("들어온 값의 한계는 "+total);
	}
	private static int valueSum(String ... value) {
		//String[] value = {("10","20")};
		int result = 0;//누적변수
		for(int i=0; i<value.length; i++) {
			result += Integer.parseInt(value[i]); //Integer = int  스트링을 정수로 바꾸고싶을때.
			//Integer.parseInt(Val); val 문자열을 정수로 바꿈.  Integer.parseInt 많이 쓰인다.
		}
	return result;	
	}
}
