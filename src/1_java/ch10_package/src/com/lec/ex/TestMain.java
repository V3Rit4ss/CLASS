package com.lec.ex;  //서로 같은 클래스의 충돌을 막기위한 방법.

import com.acom.ex.Emp;

public class TestMain {
	public static void main(String[] args) {
		Emp emp = new Emp(101); //acom
		com.bcom.ex.Emp emp1 = new com.bcom.ex.Emp();	//bcom 같은이름의 클래스를 쓸때는 하나는 무조건 풀네임으로 써야한다, 변수도 다르게 해야하고.
	}
}
