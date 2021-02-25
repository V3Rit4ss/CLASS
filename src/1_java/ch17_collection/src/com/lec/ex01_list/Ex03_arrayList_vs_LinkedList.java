package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex03_arrayList_vs_LinkedList {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		LinkedList<String> linked = new LinkedList<String>();
		
		System.out.println("arrayList 순차적 추가 시간 : "+addseqTime(array)); //.add 한거
		System.out.println("linkedList 순차적 추가 시간 : "+addseqTime(linked));
		System.out.println("arrayList 중간인덱스로 추가 시간 : "+addRandTime(array));  //중간에 넣는거
		System.out.println("linkedList 중간인덱스로 추가 시간 : "+addRandTime(linked));
		System.out.println("arrayList 끝부터 삭제 하는 시간 : "+removeSeqTime(array));
		System.out.println("linkedList 끝부터 삭제 하는 시간 : "+removeSeqTime(linked));
		System.out.println("arrayList 중간부터 지우는 시간 : "+removeRandTime(array));
		System.out.println("linkedList 중간부터 지우는 시간 : "+removeRandTime(linked));
		
		
	}
	
	private static long removeRandTime(List<String>list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<list.size(); i++) {
			list.remove(0);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	
	
	private static long removeSeqTime(List<String>list) { //지우는 시간차는 별로 안남.
		long start = System.currentTimeMillis(); //시작시간
		for(int i =list.size()-1; i>1000; i--) {
			list.remove(i);  //끝부터 삭제하는. 링크드는 처음부터 끝까지 그 자리를 찾아서 삭제함.
		}
		long end = System.currentTimeMillis(); //완료시간
		return end - start;
	}
	
	
	private static long addRandTime(List<String> list) {
		long start = System.currentTimeMillis(); //for문 수행 전 시간
		for(int i =0; i<1000; i++) {
			list.add(100, "중간인덱스로 추가");
		}
		
		long end = System.currentTimeMillis(); // for문 수행 후 시간
		return end-start;
	}
	
	
	private static long addseqTime(List<String> list) {
		long start = System.currentTimeMillis();  //시작시간
		for(int i=0; i<5000000; i++) {
			list.add("순차적으로 추가");// add 해서 하나씩 생기는거.
		}
		
		long end = System.currentTimeMillis(); //for문 수행후 시간.
		return end - start;
	}
}
