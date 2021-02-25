package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {  //Integer 로 기본형을 객체형으로 바꿔서 넣어야함.
		HashSet<String> hashset = new HashSet<String>();
		//str0 str1 str2 str3  str2
		hashset.add("str2"); //hashset = str2.equals 를 하나씩 해본다.
		hashset.add("str0");
		hashset.add("str1");
		hashset.add("str2");
		hashset.add("str3");
		System.out.println(hashset);
		System.out.println("hashset 사이즈"+hashset.size());
		hashset.add("str2");
		System.out.println(hashset);
		System.out.println("hashset 사이즈"+hashset.size());
		Iterator<String> iterator = hashset.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
