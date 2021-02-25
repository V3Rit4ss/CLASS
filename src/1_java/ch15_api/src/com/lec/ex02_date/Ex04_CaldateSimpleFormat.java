package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex04_CaldateSimpleFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//2020년 12월 14일 3시 03분 05초 스타일로 하고싶다 하면.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초 ");
		//[yyyy = 2020년] , [yy= 20] , [M = 9월] , [MM = 09] , [dd = 09일] , [d = 9] [E 요일]  [a or p 오전오후.]
		// H 24시 h 12시 m분 s 초 S밀리세컨 w 이번년도에 몇번째 주인지  W 이번월에 몇번째 주 인지. D 올해의 몇번째 날.
		
		String today = sdf.format(cal.getTime());
		System.out.println(today);
		
		
		
	}
}
