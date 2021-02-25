package com.lec.ex;
//논리연산자(&& : and , || : or)
// true && true = true
// true && false = false
// false && true = false
// false && false = false
public class Ex_04 {
	public static void main(String[] args ) {
		int i=1, j=10 , h=10;
		//"안녕하세여"+1 : 스트링과 숫자는 합해지지 않기에 스트링 과 스트링 으로 나옴.
		System.out.println("i<j && ++j>h 는"+ ((i<j) && (++j>h)  )); 
		System.out.println("j="+j);
		
		System.out.println("i>j && ++j>h 는"+ ((i>j) && (++j>h)  )); //앞이 false 면 뒤는 연산안함. 
		System.out.println("j="+j);
		
		
		
		System.out.println("i<j || ++j>h 는"+ ((i<j) || (++j>h)  )); // 트루 값이면 뒤를 안봄
		System.out.println("j="+j);
		
		System.out.println("i>j || ++j>h 는"+ ((i>j) || (++j>h)  ));
		System.out.println("j="+j);
	}
}
