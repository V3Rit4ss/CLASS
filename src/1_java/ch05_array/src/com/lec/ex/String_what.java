//(String[] args) 해부. 
//java hello 장동건 고소영 설현 
package com.lec.ex;

public class String_what {
	public static void main(String[] args) { //java hello 장동건 고소영 설현   
		System.out.println("String_what");
		for(String name : args) {
			System.out.println(name+".");
		}
	}
}
// 한마디로 무슨말이냐면 스트링 [] args 의 [] 은 배열에서 배운 객체주소 공간이다.