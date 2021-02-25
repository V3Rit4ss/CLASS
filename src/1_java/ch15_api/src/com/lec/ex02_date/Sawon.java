package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {// part 를 스트링으로 썼지만 바뀌면 안돼는 정보이니 static final 변수를 써도 되고.
	private String num;   // enum PartType 이라는 타입을 만들어서 넣을수있다.
	private String name;
	private String part;
	private Date enterDate;
	public Sawon(String num, String name, String part) {
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date(); //현재 표시.
	}
	public Sawon(String num, String name , String part , int y, int m, int d) {
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date(new GregorianCalendar(y,m-1,d).getTimeInMillis());
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		String result = "[사원번호]"+num+"[이름]"+name+"[부서]"+part+"[입사일]"+sdf.format(enterDate);
		return result ;
	}
}
