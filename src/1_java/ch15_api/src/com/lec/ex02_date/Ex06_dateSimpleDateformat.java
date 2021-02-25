package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex06_dateSimpleDateformat { //Date 쓰고 컨+ 스페이스바  = 자바 유틸을 선택함.
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd(E) HH : mm");
		System.out.println(sdf.format(date));
	}
	
	
}
