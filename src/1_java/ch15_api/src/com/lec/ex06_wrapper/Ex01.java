package com.lec.ex06_wrapper;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		if(i==j) {
			System.out.println("i와 j는 같다.");
		}//obj 는 객체이다.
		Integer obj1 = new Integer(10); //가능. //기초데이터가  오브젝트에 들어갈때는 객체데이터로 바뀐다.
		Integer obj2 = new Integer(10);
		if("Hello".equals(i)) { //이퀄스 안에 i 도 10도 가능.
			System.out.println("같다");
		}else {
			System.out.println("같지않다.");
		}
		if(obj1.equals(obj2)) {
			System.out.println("obj1과 obj2 의 데이터는 같다.");
		}
	//	int total = obj1.intValue() + obj2.intValue();  //원래는 이렇게 해야함.
		int total = obj1 +obj2;  //이것이 가능.
	}
}
