package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {  //Integer �� �⺻���� ��ü������ �ٲ㼭 �־����.
		HashSet<String> hashset = new HashSet<String>();
		//str0 str1 str2 str3  str2
		hashset.add("str2"); //hashset = str2.equals �� �ϳ��� �غ���.
		hashset.add("str0");
		hashset.add("str1");
		hashset.add("str2");
		hashset.add("str3");
		System.out.println(hashset);
		System.out.println("hashset ������"+hashset.size());
		hashset.add("str2");
		System.out.println(hashset);
		System.out.println("hashset ������"+hashset.size());
		Iterator<String> iterator = hashset.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
