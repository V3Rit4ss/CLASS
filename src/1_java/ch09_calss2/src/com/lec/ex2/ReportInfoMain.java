package com.lec.ex2;

public class ReportInfoMain {
	public static void main(String[] args) {
		ReportInfo[] reportInfo = { new ReportInfo("정우성", 84, 96, 85) , new ReportInfo("김하늘", 52, 85, 51) , new ReportInfo("황정민", 91, 98, 83) , new ReportInfo("강동원", 87, 70, 90) , new ReportInfo("유아인", 87, 80, 68)};
		String[] title = {"이름","국어" , "영어" , "수학", "총점", "평균"};
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t\t\t성적표");
		System.out.println("\t---------------------------------------------");
//		for(int i=0 ; i < title.length ; i++) {
//			System.out.println("\t "+title[i]);
//		}
		for(String t : title) {
			System.out.print("\t"+t);
		}
		System.out.println();
		System.out.println("\t---------------------------------------------");
		for(ReportInfo r : reportInfo) {
			r.print();
		}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
}
