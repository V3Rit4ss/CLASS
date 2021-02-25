package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.lec.ex01_string.Friend;

public class Ex07_birthday04 {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동" , "010-9999-9999" , "12-14") , new Friend("홍당무" , "010-8888-8888" , "01-01") , new Friend("신길동" , "010-1234-1234" , "12-14") };
		
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now.getTime());
		System.out.println("오늘은"+today);
		boolean searchOk = false;
		System.out.println("오늘 생일인 사람의 목록은 다음과 같습니다.");
		for(int idx = 0; idx<friends.length; idx++) {
			String birthday = friends[idx].getBirth();
			if(birthday.equals(today)) {
				System.out.println(friends[idx]);
				searchOk = true;
			}
		}
		if (!searchOk) {
			System.out.println("오늘 생일인 사람은 없습니다.");
		}
		
		
		
		
	}
}
