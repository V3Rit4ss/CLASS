package com.lec.ex02_date;

import java.util.Date;
import java.util.GregorianCalendar;

//date 형.
public class Ex08_dateCal {
	public static void main(String[] args) {
		GregorianCalendar now = new GregorianCalendar(); //()안에 아무것도 않넣으면 현재(지금).	
		GregorianCalendar thatTime = new GregorianCalendar(2020, 10 , 30 , 9 , 30 , 0); //시스템은 0월 부터라서 10으로 씀.
		long nowMillis = now.getTimeInMillis(); //1970~ 12/14
		long thatMillis = thatTime.getTimeInMillis(); // 1970~ 11/30
		
		long day = (nowMillis - thatMillis)/(1000*60*60*24);
		System.out.println("개강한 이후"+day+"일 지남.");
		
		Date thatDay = new Date(new GregorianCalendar(2020, 10, 30, 9, 30, 0).getTimeInMillis());;//지금 -> Date thatDay = new Date();

		
		
		
	}
}
