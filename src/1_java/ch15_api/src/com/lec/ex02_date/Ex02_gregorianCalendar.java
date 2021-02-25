package com.lec.ex02_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02_gregorianCalendar {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();   //싱글톤이 아니라 new 가능.
		//System.out.println(gc);  //cal -> gc
		
		int year = gc.get(Calendar.YEAR); // YEAR 스태틱 변수.
		int month = gc.get(Calendar.MONTH) + 1; // 시스템은 0월부터. 0월 = 1월 , 11월 = 12월 : 따라서 +1을 붙힘
		int day = gc.get(Calendar.DAY_OF_MONTH);
		int week = gc.get(Calendar.DAY_OF_WEEK);// 1(일) 2(월) 3(화)
		int hour24 = gc.get(Calendar.HOUR_OF_DAY);// 24시간
		int hour = gc.get(Calendar.HOUR);// 12시간
		int ampm = gc.get(Calendar.AM_PM); // 0(am) , 1(pm)
		int minute = gc.get(Calendar.MINUTE);
		int second = gc.get(Calendar.SECOND);
		int millisec = gc.get(Calendar.MILLISECOND);
		System.out.printf("%d년%d월%d일", year, month, day);
		switch (week) {
		case 1:
			System.out.print("일요일");
			break;
		case 2:
			System.out.print("월요일");
			break;
		case 3:
			System.out.print("화요일");
			break;
		case 4:
			System.out.print("수요일");
			break;
		case 5:
			System.out.print("목요일");
			break;
		case 6:
			System.out.print("금요일");
			break;
		case 7:
			System.out.print("토요일");
			break;
		}
		System.out.printf("%d시 %d분 %d초 %d\n" , hour24 , minute, second , millisec);
		
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tH시 %tM분 %tS초\n", gc , gc , gc , gc , gc , gc , gc);
		
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초 \n", gc ); //cal 을 한번만 쓰고싶으면 %' 1$ 'tY
		
		System.out.print((ampm == 0)? "오전":"오후");
		System.out.printf("%d시 %d분 %d초 \n", hour , minute , second);
		System.out.printf("%tl시 %tM분 %tS초 \n", gc , gc , gc);
		System.out.printf("%1$tl시 %1$tM분 %1$tS초 \n", gc);
		
	}
}
