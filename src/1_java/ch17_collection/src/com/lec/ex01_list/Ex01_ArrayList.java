package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex01_ArrayList { // int �迭�� �Ұ�.
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		for (int idx = 0; idx < array.length; idx++) {
			System.out.println("array[" + idx + "] = " + array[idx]);
		}
		// ����Ʈ �ؾ���. //<Integer> <int �Ұ�>

		for (String arr : array) {

			System.out.println(arr);

		}

		ArrayList<String> arrayList = new ArrayList<String>(); // ��ü���� ���� �Ϸ�.
		arrayList.add("str0"); // 0�ε��� ����.
		arrayList.add("str1"); // 1�� //1���� 2�� 2.
		arrayList.add("str2"); // 2�� //2���� 3������ 3. //���� �߰��ֱ��ϸ� �и���.
		arrayList.add(1, "111111"); // 1������ �߰� �ֱ��ϸ� 1.
		for (int idx = 0; idx < arrayList.size(); idx++) {
			System.out.println("arrayList�� " + idx + "��°= " + arrayList.get(idx));
		}
		
		arrayList.remove(1); //1�� �ε����� ���� (2���ε����� 1������, 3���ε����� 2������.) =������ ������� .
			System.out.println(arrayList);
		arrayList.clear(); //arrayList �� ��� ������ ����.
		//	if(arrayList.size()==0) �̰͵� ����
			if(arrayList.isEmpty()) {
				System.out.println("arrayList �����");
				
			}
			
			
			System.out.println(arrayList);
//			arrayList = null; //�̷��� �ϸ� �ȴ� ������ ������
//			if(arrayList.size()==0) {
//				System.out.println("arrayList �����.");
//			}
		
		for (String arr : arrayList) {
			System.out.println(arr);

		}
	}
}
