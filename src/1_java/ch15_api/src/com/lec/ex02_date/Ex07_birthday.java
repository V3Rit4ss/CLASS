package com.lec.ex02_date;
//집가서 다시. 칼렌더 형 , 그레고리안 , 데이트 형 하나씩.

import java.util.Calendar;

import com.lec.ex01_string.Friend;

public class Ex07_birthday {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "12-14"), new Friend("홍길동", "010-8888-8888", "01-01"),
				new Friend("홍길동", "010-1234-1234", "12-14") };
		// friends 배열에서 오늘이 새일 사람들의 목록 출력
		// 오늘 생일인 사람이 없으면 없다고 출력.
		Calendar now = Calendar.getInstance();
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);

		String monthString = (month < 10) ? "0" + month : "" + month;
		String dayString = (day < 10) ? "0" + day : "" + day;
		String today = monthString + "-" + dayString;
		System.out.println("오늘은" + today);
		boolean searchOk = false;
		System.out.println("오늘 생일인 사람의 목록은 다음과 같습니다.");
		for (int idx = 0; idx < friends.length; idx++) {
			String birthday = friends[idx].getBirth();
			if (birthday.equals(today)) {
				System.out.println(friends[idx]);
				searchOk = true;

			}

		}
		if(!searchOk) {
			System.out.println("오늘이 생일인 사람은 없습니다.");
		}
	}
}
