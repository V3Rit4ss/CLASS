package com.lec.ex02_date;

import java.util.Date;

public class Ex03_Date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		int year = date.getYear() + 1900 ;              //줄이 그어져있는건 수정될수도있으니 쓰지는 말라. 즉, 다른걸로 써.
		int month = date.getMonth()+1;
		int day = date.getDate();
		int hour = date.getHours();
		int minute = date.getMinutes();
		int second = date.getSeconds();
		System.out.printf("%d년 %d월 %d일 %d시 %d분 %d초\n", year, month , day , hour , minute , second);
		System.out.printf("%tY년 %tm월 %td일 %tH시 %tM분 %tS초\n" , date,date,date,date,date,date);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초\n" , date);
	}
}
