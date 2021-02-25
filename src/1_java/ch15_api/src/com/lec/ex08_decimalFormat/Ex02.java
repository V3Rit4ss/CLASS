package com.lec.ex08_decimalFormat;

import java.text.DecimalFormat;
//���� �ڸ���  : #(������ ��� ������ ���x )  0: �ݵ�� ���    , % E(������)
public class Ex02 {
	public static void main(String[] args) {
		//�迭�� �־ �ѹ� �غ�.
		String[] patterns = {"00000000.00000" ,"########.##", "#,###,###.00000","#.##%","#.#%","#.#####E00"};
		double number = 1234567.8889;
		for(String pattern : patterns) {
			DecimalFormat df = new DecimalFormat(pattern);
			System.out.println(df.format(number));
			
		}
//		DecimalFormat df1 = new DecimalFormat("00000000.00000");
//		System.out.println(df1.format(number));
//		DecimalFormat df2 = new DecimalFormat("########.##");
//		System.out.println(df2.format(number));
//		DecimalFormat df3 = new DecimalFormat("#,###,###.00000");
//		System.out.println(df3.format(number));
//		DecimalFormat df4 = new DecimalFormat("#.##%");
//		System.out.println(df4.format(number));
//		DecimalFormat df5 = new DecimalFormat("#.#%"); //�Ҽ��� ���ڸ��� ������ �Ҷ��� �ݿø�.
//		System.out.println(df5.format(number));
//		DecimalFormat df6 = new DecimalFormat("#.#####E00");
//		System.out.println(df6.format(number));
	}
}
