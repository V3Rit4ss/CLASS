package com.lec.person_dao;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {
		PersonDto dto = new PersonDto("ȫ�浿", "����", 99, 99, 99);
		PersonDao dao = PersonDao.getINTANCE();
		int result = dao.insertPerson(dto);
		System.out.println(result==PersonDao.SUCCESS? "�Է¼���":"�Է½���");
		System.out.println("=========2�� �׽�Ʈ �մϴ�.===============");
		ArrayList<PersonDto> dtos = dao.selectJname("���");
		if(dtos.size()==0) { //������.
			System.out.println("��찡 �����ϴ�.");
		}else {
			
			for(PersonDto d : dtos)
				System.out.println(d);
		}
		System.out.println("=============3�� �׽�Ʈ �մϴ�.=================");
		dtos = dao.selectAll();
		if(dtos.isEmpty()) {
			System.out.println("��ϵ� ����� �����ϴ�.");
		}else {
			for(PersonDto d : dtos)
				System.out.println(d);
		}
		
		
		
	}
}
