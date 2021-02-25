package com.lec.ex01_list;

import java.util.Vector;

public class Ex04_vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		AClass objA = new AClass();
		BClass objB = new BClass();
		vec.add(objA); //0번 인덱스 
		vec.add(objB);//1번 인덱스
		vec.add("C"); //2번 인덱스
		vec.add(10);   // vec.add(new Integer(10));  => 오브젝트안에 자동적으로 뉴 인테져 로 객체형으로 변환해서 들어감.
		
		System.out.println(vec);
		for(int i=0; i<vec.size(); i++) {
			System.out.println(vec.get(i)/*.toString()*/); 
		}
		if(vec.isEmpty()) {
			System.out.println("vec에 데이터가 없습니다.");
		}else {
			System.out.println("vec에 데이터가 없습니다.");
		}
	}
}
