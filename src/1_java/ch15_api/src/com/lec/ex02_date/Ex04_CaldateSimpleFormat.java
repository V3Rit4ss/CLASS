package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex04_CaldateSimpleFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//2020�� 12�� 14�� 3�� 03�� 05�� ��Ÿ�Ϸ� �ϰ�ʹ� �ϸ�.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a hh�� mm�� ss�� ");
		//[yyyy = 2020��] , [yy= 20] , [M = 9��] , [MM = 09] , [dd = 09��] , [d = 9] [E ����]  [a or p ��������.]
		// H 24�� h 12�� m�� s �� S�и����� w �̹��⵵�� ���° ������  W �̹����� ���° �� ����. D ������ ���° ��.
		
		String today = sdf.format(cal.getTime());
		System.out.println(today);
		
		
		
	}
}
