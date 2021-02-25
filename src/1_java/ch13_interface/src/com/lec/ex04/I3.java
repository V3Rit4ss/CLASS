package com.lec.ex04;
//i1, i2, m1(), m2() 있음. // 다중으로 물려줘도 같은 이름이 오류가 안난다.
public interface I3 extends I1, I2{ //i1 과 i2 를 상속한 인터페이스.
	public int i3 = 3;
	public void m3();
	
}
