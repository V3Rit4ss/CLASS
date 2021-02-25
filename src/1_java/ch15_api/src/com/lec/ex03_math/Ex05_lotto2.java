package com.lec.ex03_math;

import java.util.Random;

public class Ex05_lotto2 {
	public static void main(String[] args) {
		Random random = new Random();
		int[] lotto = new int[6];
		for(int i=0; i<lotto.length; i++) {
			int temp = random.nextInt(45)+1;
			boolean ok = true;
			for(int j = 0; j<i; j++) {
				if(temp==lotto[j]) { //중복된것 뽑힌 경우
					i--;
					ok = false;
					break; //for-j 의 반복문 빠져나감.
				}
			}//중복 확인 for문
			if(ok) {
				lotto[i] = temp;
			}
			
		}
		
		for(int l : lotto) {
			System.out.print(l+"\t");
		}
		
		
		
	}
}
