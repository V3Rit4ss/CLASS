package com.lec.ex01_list;

import java.util.LinkedList;//����Ʈ �ض�~~

public class Ex02_LinkedList {
	public static void main(String[] args) {
		//LinkedList<object>
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0"); //0�� �ε���
		linkedList.add("str1"); //1�� �ε���   //2��
		linkedList.add("str2"); //2�� �ε��� //3��
		linkedList.add(1, "1111"); //1���ε��� //�߰��� ������ �ӵ� ���� ����.
		System.out.println(linkedList);
		for(int i=0; i<linkedList.size(); i++) {
			System.out.println(linkedList.get(i));
			linkedList.remove("1111");
			linkedList.clear();
			System.out.println(linkedList.isEmpty()? "�������." : "�Ⱥ������");
		}
	}
}
