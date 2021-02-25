package com.lec.ex02_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
	//	String[] strArr = new String[5];
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("str11");
		HashMap<Integer, String> hashmap = new HashMap<Integer,String>(); 
		hashmap.put(11, "str11"); //키값이 중복이면 안댐  키값은 순서아니여도 댐
		hashmap.put(22, "str22");
		hashmap.put(39, "str39");
		System.out.println(hashmap.get(39)); 
		System.out.println("remove 전 : "+hashmap); //나오는 순서는 랜덤
		hashmap.remove(22);
		System.out.println("remove 후 : "+hashmap);
		hashmap.clear(); //해쉬맵의 데이터 전체 삭제
		hashmap.put(0, "Hong gildong"); //키값을 순서대로 가져오는법
		hashmap.put(1, "Kim gildong");
		hashmap.put(2, "Lee soonsin");
		hashmap.put(3, "Yu ain");
		//인덱스가 없어서 이걸쓴다.  
		Iterator<Integer> iterator = hashmap.keySet().iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key+"의 데이터는"+hashmap.get(key));
		}
		
		
	}
}
