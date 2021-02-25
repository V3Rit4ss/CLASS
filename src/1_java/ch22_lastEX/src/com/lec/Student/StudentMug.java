package com.lec.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMug {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentDao dao = StudentDao.getINTANCE();
		String fn ;
		
		do {
			System.out.println("1: �Է� || 2: �а���� || 3: ��ü��� || 4: ������ ��� || �׿� :����");
			fn = sc.next();
			switch(fn) {
			case "1" : //�̸� , �а���, ����, �Է¹޾� dao.insertStudent()ȣ��
				System.out.print("�Է��� �̸��� ?");
				String sName = sc.next();
				System.out.print("�Է��� �а���?");
				String mName = sc.next();
				System.out.print("�Է��� ������?");
				int score = sc.nextInt();
				if(score <= 0 || score >= 100) {
					System.out.println("��ȿ���� ���� ������ �Է� �ϼ̽��ϴ�. �ٽ� �Է� ���ּ���.");
					continue;
				}
				int result = dao.insertStudent(sName, mName, score);
				System.out.println(result==StudentDao.SUCCESS? "�Է� ����":"�Է� ����");
				
				break;
				
			case "2" : 
				System.out.print(" ��ȸ�� �а�����? [ �������� || �濵������ || ��ǻ�Ͱ��� || ����Ʈ���� || �ΰ������� ]");
				mName = sc.next();
				ArrayList<StudentDto> students = dao.selectMname(mName);
				if(students.size() != 0) {
					System.out.println("���\t�̸�\t�а�\t����");
					for(StudentDto student : students) {
						System.out.println(student);
					}
				}else {
					System.out.println("�ش� �а� �л��� �����ϴ�.");
				}
				break;
				
			case "3" : 
				students = dao.selectStudent();
				if(students.size() != 0) {
					System.out.println("���\t�̸�\t�а�\t����");
					for(StudentDto student : students) {
						System.out.println(student);
					}
				}else {
					System.out.println("�ش� �а� �л��� �����ϴ�.");
				}
				break;
				
			case "4" :
				students = dao.selectExpel();
				if(students.size() != 0 ) {
					System.out.println("���\t�̸�\t�а�\t����");
						for(StudentDto student : students) {
							System.out.println(student);
						}
						
					}else {
						System.out.println("�ش� �а� �л��� �����ϴ�.");
					}
				
					break;
				}
			
			
			
		}while (fn.equals("1")||fn.equals("2")||fn.equals("3")||fn.equals("4")) ;
			System.out.println("bye");
		
		
	}
}
