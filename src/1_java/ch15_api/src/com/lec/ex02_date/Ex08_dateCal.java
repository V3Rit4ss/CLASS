package com.lec.ex02_date;

import java.util.Date;
import java.util.GregorianCalendar;

//date ��.
public class Ex08_dateCal {
	public static void main(String[] args) {
		GregorianCalendar now = new GregorianCalendar(); //()�ȿ� �ƹ��͵� �ʳ����� ����(����).	
		GregorianCalendar thatTime = new GregorianCalendar(2020, 10 , 30 , 9 , 30 , 0); //�ý����� 0�� ���Ͷ� 10���� ��.
		long nowMillis = now.getTimeInMillis(); //1970~ 12/14
		long thatMillis = thatTime.getTimeInMillis(); // 1970~ 11/30
		
		long day = (nowMillis - thatMillis)/(1000*60*60*24);
		System.out.println("������ ����"+day+"�� ����.");
		
		Date thatDay = new Date(new GregorianCalendar(2020, 10, 30, 9, 30, 0).getTimeInMillis());;//���� -> Date thatDay = new Date();

		
		
		
	}
}
