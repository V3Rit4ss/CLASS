package com.lec.ex01_interface;
//InterfaceEx1 InterfaceEx2
//interfaceClass
public class TestMain {  //인터페이스클래스 라는 아래 개체가 윗개체를 가질수는 있지만, 윗개체ex1 이 ex2 의 개체를 가질수 없다.
	public static void main(String[] args) { //즉, '인간(ex3) = 포유루(ex2)'.  '동물(ex1),포유루(ex2) 은 인간(ex3) 이다' 라는 불가 인것처럼.
		//Interface_Ex01 ex01 = new Interface_Ex01(); 불가
		//Interface_Ex02 ex02 = new Interface_Ex02(); 불가
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		
		Interface_Ex01 obj2 = new InterfaceClass();//1
		obj2.method1();
		//obj2.me2thod2(); 불가 인터페이스ex1 에는 메소드2가 없음.    
		
		// 1과 2의 생김새는 같으나 다른일을 하는것을 다형성 이라 한다.
		
		Interface_Ex02 obj3 = new InterfaceClass();//2
		if(obj3 instanceof InterfaceClass) { //obj3 이 인터페이스클래스에 있냐 라고 물어보고 형변환 하는게 좋음.
		((InterfaceClass)obj3).method1(); // ((InterfaceClass)obj3) 명시적 형변환. 함부로 하는건 위험.
		}
	//	obj3.method1(); 불가.
		obj3.method2();
		
		// 다형성  : 함수 다형성   = 오버로딩, 오버라이딩
//			    : 변수 다형성   = 
	}
}
