package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Ex05_gcSimpleDateFormat {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("MM월 d일 (E) a h시 m분");  // 출력 하고싶은 스타일.
		System.out.println(sdf.format(gc.getTime()));
	}
}
