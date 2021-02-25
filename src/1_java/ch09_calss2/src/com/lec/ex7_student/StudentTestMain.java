package com.lec.ex7_student;

public class StudentTestMain {
	public static void main(String[] args) {
		Student[] student = { new Student("정우성", 84, 96, 85) , new Student("김하늘", 52, 85, 51) , new Student("황정민", 91, 98, 83) , new Student("강동원", 87, 70, 90) , new Student("유아인", 87, 80, 68)};
		String[] title = {"번호","이름","국어" , "영어" , "수학", "총점", "평균"};
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t\t\t성적표");
		System.out.println("\t-------------------------------------------------------");
//		for(int i=0 ; i < title.length ; i++) {
//			System.out.println("\t "+title[i]);
//		}
		for(String t : title) {
			System.out.print("\t"+t);
		}
		System.out.println();
		System.out.println("\t--------------------------------------------------------");
		for(Student s : student) {
			s.print();
		}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
}

