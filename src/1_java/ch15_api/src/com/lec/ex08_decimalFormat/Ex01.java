package com.lec.ex08_decimalFormat;

import java.text.DecimalFormat;
//숫자 자리에  : #(잇으면 출력 없으면 출력x )  0: 반드시 출력    , % E(지수형)
public class Ex01 {
	public static void main(String[] args) {
		double number = 1234567.8889;
		DecimalFormat df1 = new DecimalFormat("00000000.00000");
		System.out.println(df1.format(number));
		DecimalFormat df2 = new DecimalFormat("########.##");
		System.out.println(df2.format(number));
		DecimalFormat df3 = new DecimalFormat("#,###,###.00000");
		System.out.println(df3.format(number));
		DecimalFormat df4 = new DecimalFormat("#.##%");
		System.out.println(df4.format(number));
		DecimalFormat df5 = new DecimalFormat("#.#%"); //소숫점 한자리만 나오게 할때는 반올림.
		System.out.println(df5.format(number));
		DecimalFormat df6 = new DecimalFormat("#.#####E00");
		System.out.println(df6.format(number));
	}
}
