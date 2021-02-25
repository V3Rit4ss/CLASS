package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		S s =new S();
		//A a = new A(); //원래는 이렇게 했지만.
		S a = new A();  // 상속되었기 때문에 이렇게 해도 가능.
//		Object a = new A(); 오브젝트에는 없기에 이거는 안된다.
		System.out.println(a.s);
		S b = new B();
		S c = new C();
		S[] sArr = {new A(), new B(), new C()};
	}

}
