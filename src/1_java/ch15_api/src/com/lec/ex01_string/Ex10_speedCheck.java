package com.lec.ex01_string;
//스티링 버퍼의 속도 차이가 얼마나 날까?
//https://www.epochconverter.com/clock 
public class Ex10_speedCheck {
	public static void main(String[] args) {
		String str = "A";
		//시작시간 측정
		long start = System.currentTimeMillis();
		for(int i = 0; i<50000 ; i++) {
			str = str.concat("a"); //1.a  2.aa 3.aaa ~ 50000. aaaaa~~
		}
		//끝 시간 측정.
		long end = System.currentTimeMillis();
		System.out.println("스트링 변경 시간 : "+(end-start));
		
		StringBuffer strBuff = new StringBuffer("A");
		start = System.currentTimeMillis();
		for(int i =0; i<50000 ; i++) {
			strBuff.append("a");
		}
		
		end = System.currentTimeMillis();
		System.out.println("Stringbuff 변경 시간 : "+(end-start));
		
		StringBuilder strBuil = new StringBuilder("A");
		start = System.currentTimeMillis();
		for(int i = 0; i<50000; i++) {
			strBuil.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuilder 변경 시간 : "+(end-start));
	}
}
