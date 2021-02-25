package com.lec.ex01_list;

import java.util.LinkedList;//임폴트 해라~~

public class Ex02_LinkedList {
	public static void main(String[] args) {
		//LinkedList<object>
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0"); //0번 인덱스
		linkedList.add("str1"); //1번 인덱스   //2번
		linkedList.add("str2"); //2번 인덱스 //3번
		linkedList.add(1, "1111"); //1번인덱스 //중간에 넣을때 속도 저하 없음.
		System.out.println(linkedList);
		for(int i=0; i<linkedList.size(); i++) {
			System.out.println(linkedList.get(i));
			linkedList.remove("1111");
			linkedList.clear();
			System.out.println(linkedList.isEmpty()? "비워졌다." : "안비워졌다");
		}
	}
}
