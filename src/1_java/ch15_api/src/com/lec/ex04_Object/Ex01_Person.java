package com.lec.ex04_Object;

public class Ex01_Person {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = new String("java");
		if(str1.equals(str2)) {
			System.out.println("str1 과 str2 는 같은 문자열이다");
		}else {
			System.out.println("str1 과 str2 는 다른 문자열이다.");
		}
		Person p1 = new Person(9201211234560L); //L 롱형으로 바뀌어서 들어간다.
		Person p2 = new Person(9201211234560L);
		if(p1.equals(p2)) {  
			System.out.println("같은 객체다");
		}else {
			System.out.println("다른 객체다.");
		}
	}
}
