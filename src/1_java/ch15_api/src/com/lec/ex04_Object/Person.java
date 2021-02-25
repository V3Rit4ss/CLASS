package com.lec.ex04_Object;

public class Person {
	private long juminNo; // ex)9201211234560

	public Person(long juminNo) {

		this.juminNo = juminNo;

	}

	@Override
	public boolean equals(Object obj) {
		// Person p3; 객체가없다
		// p1.equals(p3) false | p1.equals(str1) false
		// p1.equals(p2) -> this(p1) obj(p2)
		// this.juminNo와 obj.juminNo가 같으면 true를 return
		if (obj != null && obj instanceof Person) {
			// juminNo == obj.juminNo 의 여부 return
			return juminNo == ((Person) obj).juminNo; // ((Person)obj) 형변환.
		} else { //else 를  지워도 아래와 같이 같다.
			return super.equals(obj);
		}
	}//main
}//class
