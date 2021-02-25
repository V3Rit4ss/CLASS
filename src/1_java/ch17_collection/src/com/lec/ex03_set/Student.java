package com.lec.ex03_set;

public class Student {
	private String name;
	private int grade;
	public Student(String name, int grade) {
		
		this.name = name;
		this.grade = grade;
	}
	@Override
	public String toString() {
		
		return name + ":" +grade; //   "홍길동:5"
	}
	
	@Override// new Student("장보고",1).equlas(new Student("장보고",1)) 이런 작업를 한다.
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj!=null && obj instanceof Student) {
			boolean nameChk = name.equals(((Student)obj).name);
			boolean gradeChk = grade == ((Student)obj).grade;
			return nameChk && gradeChk;  //위로 쓰나 아래로 쓰나
		//	return toString().equals(obj.toString());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return toString().hashCode();  //         투스트링쓰면  "장보고:1" 그래서 해쉬코드를 보려고 해쉬코드를 넣음.
		
	}
}
