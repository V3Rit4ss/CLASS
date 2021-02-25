package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex01_ArrayList { // int 배열이 불가.
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		for (int idx = 0; idx < array.length; idx++) {
			System.out.println("array[" + idx + "] = " + array[idx]);
		}
		// 임폴트 해야함. //<Integer> <int 불가>

		for (String arr : array) {

			System.out.println(arr);

		}

		ArrayList<String> arrayList = new ArrayList<String>(); // 객체공간 세팅 완료.
		arrayList.add("str0"); // 0인덱스 잡힘.
		arrayList.add("str1"); // 1번 //1번은 2번 2.
		arrayList.add("str2"); // 2번 //2번은 3번으로 3. //따라서 중간넣기하면 밀린다.
		arrayList.add(1, "111111"); // 1번으로 중간 넣기하면 1.
		for (int idx = 0; idx < arrayList.size(); idx++) {
			System.out.println("arrayList의 " + idx + "번째= " + arrayList.get(idx));
		}
		
		arrayList.remove(1); //1번 인덱스값 삭제 (2번인덱스가 1번으로, 3번인덱스가 2번으로.) =무조건 순서대로 .
			System.out.println(arrayList);
		arrayList.clear(); //arrayList 의 모든 데이터 삭제.
		//	if(arrayList.size()==0) 이것도 가능
			if(arrayList.isEmpty()) {
				System.out.println("arrayList 비워짐");
				
			}
			
			
			System.out.println(arrayList);
//			arrayList = null; //이렇게 하면 안댐 오류뜸 ㅅㄱㅂ
//			if(arrayList.size()==0) {
//				System.out.println("arrayList 비워짐.");
//			}
		
		for (String arr : arrayList) {
			System.out.println(arr);

		}
	}
}
