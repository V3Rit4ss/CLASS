package com.lec.ex03_exceptionExs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date enterDate;  //엔터데이터에 데이터값이 없으면 null 이니까 null포인트문제가 난다.
	public Friend() {} //매개변수 없는 생성자 //초기화 안함.
	public Friend(String name, String tel) {
		
		this.name = name;
		this.tel = tel;
		enterDate = new Date(); //현 시점. 현 시각.
	}
	@Override
	public String toString() {
		String post = tel.substring(tel.lastIndexOf("-")+1);
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy년도 친구댐");
		return "Friend [name=" + name + ", tel=***-****-" + post +  sdf.format(enterDate)+"]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
