package com.lec.person_dao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMngDao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getINTANCE();  //dao 한테 일을 넘길꺼임.
		String fn;
		ArrayList<PersonDto> person ;  
		do {
			System.out.println("1: 입력 | 2: 직업출력 | 3: 전체출력 | 그외 : 종료.");
			fn = sc.next();
			switch(fn) {
			case "1" : //이름,직업명, 국영수 입력받아 dao.insertPerson() 호출.
				System.out.print("입력할 이름은?");
				String name = sc.next();
				System.out.print("입력할 직업은?");
				String jname = sc.next();
				System.out.println("입력할 국어 점수는?");
				int kor =sc.nextInt();
				System.out.println("입력할 영어 점수는?");
				int eng =sc.nextInt();
				System.out.println("입력할 수학 점수는?");
				int mat =sc.nextInt();
				PersonDto newPerson = new PersonDto(name, jname, kor, eng, mat); //넘긴거 입력해!
				int result = dao.insertPerson(newPerson); //입력끝.  (리턴값이 인트 리절트라서.)
				System.out.println(result==PersonDao.SUCCESS ? "입력성공" : "입력 실패");
				
				break;
				
			case "2" : //직업명 입력받아 dao.selectJname() 호출하여 결과 출력.
				System.out.print("조회 할 직업명은? [ 배우 | 가수 | 엠씨 ]");
				jname =sc.next(); //case 1에서 변수 선언했기때문에 이렇게함.
				person = dao.selectJname(jname); //jname 애들만 뽑아보셈.
				if(person.size()!= 0) {
					System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
					for(PersonDto p : person) {
						System.out.println(p);
					}
					
				}else { //0이면.
					System.out.println("해당 직업명의 인원이 없습니다.");
				}
				
				break;
				
			case "3" : //dao.selectAll() 호출하여 결과 출력.
				person = dao.selectAll(); //jname 애들만 뽑아보셈.
				if(person.size()!= 0) {
					System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
					for(PersonDto p : person) {
						System.out.println(p);
					}
					
				}else { //0이면.
					System.out.println("해당 직업명의 인원이 없습니다.");
				}
				
				break;

			}
		}while (fn.equals("1")||fn.equals("2")||fn.equals("3"));
		System.out.println("bye");

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
