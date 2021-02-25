package com.lec.loop;
// 1부터 20까지 누적합을 출력
// 1+2+3+4+5+6+7+8+9+10+11+12+... +19+20 = 210
public class Ex02_for {
	public static void main(String[] args) {
		int tot = 0; // 누적할 변수
		for (int i = 1; i < 21; i++) {// i <=20 이나 좋은걸로
			// tot 변수의 i값을 계속 누적 //i 값을 계속 누적하고 "i+ "나"1= " 을 출력
			tot = tot + i;
			if (i != 20) {
				System.out.print(i + " + ");
			} else {
				System.out.print(i + " = ");
			} // if
		} // for
		System.out.println("1~20까지 누적합은 " + tot);
	}// main
}// class
