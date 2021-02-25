package com.lec.ex02_throws;

public class ThrowsEx01 {
	public ThrowsEx01() throws Exception {
		actionC();
	}

	private void actionC() throws Exception {
		System.out.println("actionC 전반부");
		//try {
			actionB();
	//	}catch(Exception e) {
			
	//	}
		System.out.println("actionC 후반부");
	}

	private void actionB() throws Exception {
		System.out.println("actionB 전반부");
		//try {
		actionA();
		//}catch(ArrayIndexOutOfBoundsException e) { //타입이 다르면 실행x
		//	System.out.println("예외메세지 : "+e.getMessage());
	//	}
		System.out.println("actionB 후반부");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException { // throws 옆에 Exception 가능.
		System.out.println("actionA 전반부");
		int[] arr = { 0, 1, 2, 3 };

		System.out.println(arr[4]); // Exception 발생 .  발생된 곳으로 던져지고(Throws) 액션A로 불러진곳에 가서 실행.
										// 즉 액션A 후반부 실행 x
		System.out.println("actionA 후반부");
	}
}
