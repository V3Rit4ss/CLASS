package com.lec.ex01_string;

import java.util.Scanner;

//전번 뒷자리로 친구 찾기.
public class Ex07_sreachFriend {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동","010-9999-9999", "12-14") , new Friend("신길동","010-9999-8888", "08-14") , new Friend("마미숙","010-9999-7777", "01-14") , new Friend("길동","010-4444-9999", "02-04")}; 
		//찾을 친구의 전화번호 뒷자리를 입력 받음.
		//프랜드s 배열에서 해당 전화번호 뒷자리와 같은 친구가 있으면 그친구를 출력 and 없으면 없다고 출력.
		Scanner sc = new Scanner(System.in);
		System.out.print("찾고 싶은 친구의 전화번호 뒷자리는.");
		String sreachTel = sc.next();
		int idx; boolean searchOk = false;

		for(idx = 0; idx<friends.length; idx++) {
			String temp = friends[idx].getTel();
			String post = temp.substring(temp.lastIndexOf("-")+1);
			if(sreachTel.equals(post)) {
				System.out.println(friends[idx]); // 투스트링 안써도 나옴.
				//friends[idx].print();
				searchOk = true;
				//break;  중복이있으면 브릭을쓰면 안댐 끝까지 돌아야하니까.
			}//if
		}//for
		if(!searchOk) {
			System.out.println("해당 번호의 친구가 없습니다.");
		}
			
	
	}
}
