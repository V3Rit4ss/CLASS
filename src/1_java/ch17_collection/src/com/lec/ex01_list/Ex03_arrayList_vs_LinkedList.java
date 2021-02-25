package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex03_arrayList_vs_LinkedList {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		LinkedList<String> linked = new LinkedList<String>();
		
		System.out.println("arrayList ������ �߰� �ð� : "+addseqTime(array)); //.add �Ѱ�
		System.out.println("linkedList ������ �߰� �ð� : "+addseqTime(linked));
		System.out.println("arrayList �߰��ε����� �߰� �ð� : "+addRandTime(array));  //�߰��� �ִ°�
		System.out.println("linkedList �߰��ε����� �߰� �ð� : "+addRandTime(linked));
		System.out.println("arrayList ������ ���� �ϴ� �ð� : "+removeSeqTime(array));
		System.out.println("linkedList ������ ���� �ϴ� �ð� : "+removeSeqTime(linked));
		System.out.println("arrayList �߰����� ����� �ð� : "+removeRandTime(array));
		System.out.println("linkedList �߰����� ����� �ð� : "+removeRandTime(linked));
		
		
	}
	
	private static long removeRandTime(List<String>list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<list.size(); i++) {
			list.remove(0);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	
	
	private static long removeSeqTime(List<String>list) { //����� �ð����� ���� �ȳ�.
		long start = System.currentTimeMillis(); //���۽ð�
		for(int i =list.size()-1; i>1000; i--) {
			list.remove(i);  //������ �����ϴ�. ��ũ��� ó������ ������ �� �ڸ��� ã�Ƽ� ������.
		}
		long end = System.currentTimeMillis(); //�Ϸ�ð�
		return end - start;
	}
	
	
	private static long addRandTime(List<String> list) {
		long start = System.currentTimeMillis(); //for�� ���� �� �ð�
		for(int i =0; i<1000; i++) {
			list.add(100, "�߰��ε����� �߰�");
		}
		
		long end = System.currentTimeMillis(); // for�� ���� �� �ð�
		return end-start;
	}
	
	
	private static long addseqTime(List<String> list) {
		long start = System.currentTimeMillis();  //���۽ð�
		for(int i=0; i<5000000; i++) {
			list.add("���������� �߰�");// add �ؼ� �ϳ��� ����°�.
		}
		
		long end = System.currentTimeMillis(); //for�� ������ �ð�.
		return end - start;
	}
}
