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
		hashmap.put(11, "str11"); //Ű���� �ߺ��̸� �ȴ�  Ű���� �����ƴϿ��� ��
		hashmap.put(22, "str22");
		hashmap.put(39, "str39");
		System.out.println(hashmap.get(39)); 
		System.out.println("remove �� : "+hashmap); //������ ������ ����
		hashmap.remove(22);
		System.out.println("remove �� : "+hashmap);
		hashmap.clear(); //�ؽ����� ������ ��ü ����
		hashmap.put(0, "Hong gildong"); //Ű���� ������� �������¹�
		hashmap.put(1, "Kim gildong");
		hashmap.put(2, "Lee soonsin");
		hashmap.put(3, "Yu ain");
		//�ε����� ��� �̰ɾ���.  
		Iterator<Integer> iterator = hashmap.keySet().iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key+"�� �����ʹ�"+hashmap.get(key));
		}
		
		
	}
}
