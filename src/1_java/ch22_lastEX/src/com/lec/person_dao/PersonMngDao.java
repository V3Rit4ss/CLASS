package com.lec.person_dao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMngDao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getINTANCE();  //dao ���� ���� �ѱ沨��.
		String fn;
		ArrayList<PersonDto> person ;  
		do {
			System.out.println("1: �Է� | 2: ������� | 3: ��ü��� | �׿� : ����.");
			fn = sc.next();
			switch(fn) {
			case "1" : //�̸�,������, ������ �Է¹޾� dao.insertPerson() ȣ��.
				System.out.print("�Է��� �̸���?");
				String name = sc.next();
				System.out.print("�Է��� ������?");
				String jname = sc.next();
				System.out.println("�Է��� ���� ������?");
				int kor =sc.nextInt();
				System.out.println("�Է��� ���� ������?");
				int eng =sc.nextInt();
				System.out.println("�Է��� ���� ������?");
				int mat =sc.nextInt();
				PersonDto newPerson = new PersonDto(name, jname, kor, eng, mat); //�ѱ�� �Է���!
				int result = dao.insertPerson(newPerson); //�Է³�.  (���ϰ��� ��Ʈ ����Ʈ��.)
				System.out.println(result==PersonDao.SUCCESS ? "�Է¼���" : "�Է� ����");
				
				break;
				
			case "2" : //������ �Է¹޾� dao.selectJname() ȣ���Ͽ� ��� ���.
				System.out.print("��ȸ �� ��������? [ ��� | ���� | ���� ]");
				jname =sc.next(); //case 1���� ���� �����߱⶧���� �̷�����.
				person = dao.selectJname(jname); //jname �ֵ鸸 �̾ƺ���.
				if(person.size()!= 0) {
					System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
					for(PersonDto p : person) {
						System.out.println(p);
					}
					
				}else { //0�̸�.
					System.out.println("�ش� �������� �ο��� �����ϴ�.");
				}
				
				break;
				
			case "3" : //dao.selectAll() ȣ���Ͽ� ��� ���.
				person = dao.selectAll(); //jname �ֵ鸸 �̾ƺ���.
				if(person.size()!= 0) {
					System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
					for(PersonDto p : person) {
						System.out.println(p);
					}
					
				}else { //0�̸�.
					System.out.println("�ش� �������� �ο��� �����ϴ�.");
				}
				
				break;

			}
		}while (fn.equals("1")||fn.equals("2")||fn.equals("3"));
		System.out.println("bye");

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
