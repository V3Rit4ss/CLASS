package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex02_lotto {
	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
//		TreeSet<Iteger> lotto = new TreeSet<>();
		Random random = new Random();
		while(lotto.size()<6) {   				//for(int i=0; i<6; i++)
											//lotto.add((int)(Math.random()*45)+1);
											//int temp = random.nextInt(45)+1;
			lotto.add(random.nextInt(45)+1);  //	System.out.println(temp);
												//		lotto.add(temp);
			
			
		}
		System.out.println(lotto);
	}
}
