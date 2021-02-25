package com.lec.ex01_string;
//스티링의 단점. 100번 이상의 객체 수정을 하면 쓰레기 데이터가 늘어나면서 과부화가 걸리면서 속도가 느려짐.
public class Ex08 {
	public static void main(String[] args) {
		String str1 = "월드컵";   //  -> 이렇게 하는걸 왼쪽처럼.  String str1 = new String ("월드컵")
		String str2 = "월드컵";
		if(str1 == str2) {
			System.out.println("str1 과 str2 는 같은 객체 참조");
		}else {
			System.out.println("str1 과 str2 는 다른 객체 참조");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		str1 = str1 + "2002";  // 이렇게 하든 저렇게 하든 같음.  str1 = str1.concat("2002");
		if(str1 == str2) {
			System.out.println("str1 과 str2 는 같은 객체 참조");
		}else {
			System.out.println("str1 과 str2 는 다른 객체 참조");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}
