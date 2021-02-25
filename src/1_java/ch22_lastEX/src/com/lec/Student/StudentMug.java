package com.lec.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMug {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentDao dao = StudentDao.getINTANCE();
		String fn ;
		
		do {
			System.out.println("1: 입력 || 2: 학과출력 || 3: 전체출력 || 4: 제적자 출력 || 그외 :종료");
			fn = sc.next();
			switch(fn) {
			case "1" : //이름 , 학과명, 점수, 입력받아 dao.insertStudent()호출
				System.out.print("입력할 이름은 ?");
				String sName = sc.next();
				System.out.print("입력할 학과는?");
				String mName = sc.next();
				System.out.print("입력할 점수는?");
				int score = sc.nextInt();
				if(score <= 0 || score >= 100) {
					System.out.println("유효하지 않은 점수를 입력 하셨습니다. 다시 입력 해주세요.");
					continue;
				}
				int result = dao.insertStudent(sName, mName, score);
				System.out.println(result==StudentDao.SUCCESS? "입력 성공":"입력 실패");
				
				break;
				
			case "2" : 
				System.out.print(" 조회할 학과명은? [ 빅데이터학 || 경영정보학 || 컴퓨터공학 || 소프트웨어 || 인공지능학 ]");
				mName = sc.next();
				ArrayList<StudentDto> students = dao.selectMname(mName);
				if(students.size() != 0) {
					System.out.println("등수\t이름\t학과\t점수");
					for(StudentDto student : students) {
						System.out.println(student);
					}
				}else {
					System.out.println("해당 학과 학생이 없습니다.");
				}
				break;
				
			case "3" : 
				students = dao.selectStudent();
				if(students.size() != 0) {
					System.out.println("등수\t이름\t학과\t점수");
					for(StudentDto student : students) {
						System.out.println(student);
					}
				}else {
					System.out.println("해당 학과 학생이 없습니다.");
				}
				break;
				
			case "4" :
				students = dao.selectExpel();
				if(students.size() != 0 ) {
					System.out.println("등수\t이름\t학과\t점수");
						for(StudentDto student : students) {
							System.out.println(student);
						}
						
					}else {
						System.out.println("해당 학과 학생이 없습니다.");
					}
				
					break;
				}
			
			
			
		}while (fn.equals("1")||fn.equals("2")||fn.equals("3")||fn.equals("4")) ;
			System.out.println("bye");
		
		
	}
}
