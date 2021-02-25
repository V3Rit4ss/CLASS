package com.lec.ex02_map;

import java.util.Hashtable;
import java.util.Iterator;

public class Ex02_HashTable {
	public static void main(String[] args) {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("010-9999-9999", "홍길동");
		hashtable.put("010-8888-8888", "김길동");
		hashtable.put("010-7777-7777", "신길동");
		hashtable.put("010-6666-6666", "안길동");  //중복 되는거는 사라짐.
		System.out.println(hashtable);
		
		Iterator<String> iterator = hashtable.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key+":"+hashtable.get(key));
		}
	}
}
