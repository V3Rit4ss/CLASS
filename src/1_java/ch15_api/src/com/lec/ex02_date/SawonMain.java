package com.lec.ex02_date;

public class SawonMain {
	public static void main(String[] args) {
		Sawon s1 = new Sawon("a01","홍길동","IT");//지금 ,현재 입사한 경우 (변수) = new Date();
		Sawon s2 = new Sawon("a01","김사원","IT",2020,12,10);
		
		System.out.println(s1);
		System.out.println(s2);
	}
}
