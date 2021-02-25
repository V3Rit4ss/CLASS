package com.lec.ex0_janmuri;

class PersonInfo {
	private String name; // 이름
	private int age; // 나이
	private char gender; // 성별 "남" , "여" //퍼블릭 클래스는 둘중 하나만.

	public PersonInfo() {
	} // 생성자가 없을경우만 디폴트 생성자는 JVM 이 생성함

	public PersonInfo(String name, int age, char gender) { // 생성자 오버로딩
		this.name = name;
		this.age = age;
		this.gender = gender;
	}// 생성자 오버로딩

	public void print() {
		System.out.println("이름=" + name + "\t나이=" + age + "\t성별=" + gender);
	}

	public String inforSting() {
		String result = "이름=" + name + "\t나이=" + age + "\t성별=" + gender;
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
}// class
//public class PersonInfoTestMain {
//	public static void main(String[] args) {
//		PersonInfo p = new PersonInfo("홍길동",22,'남');
//		p.print();
//		System.out.println(p.inforSting());
//	}
//}//main   //이런 사이트는 보지말것. 잔머리임. 한곳에 클래스 메인 둘다있는거

public class PersonInfoTestMain {
	public static void main(String[] args) {
		int[] iArr = {10,20,30}; //int [] '변수' 변수이름은 내맘대로.
		PersonInfo[] person = {new PersonInfo("홍길동",20, '남') , new PersonInfo("홍길순",22, '여'), new PersonInfo()};//배열
		person[2].setName("홍길숙");
		person[2].setAge(21);
		person[2].setGender('여');
		for(PersonInfo p : person) {
			p.print();
			System.out.println(p.inforSting());
		}
//		for(int i=0; i<person.length ; i++) {   일반 for
//			System.out.println(person[i].inforSting());
//			person[i].print();
//		}
				
	} //main//배열로 바꾼거임.
}//class