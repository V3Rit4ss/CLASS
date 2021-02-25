package com.lec.ex01_runnable;

public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable target01 = new TargetEx01();  // 둘이 같다. TargetEx01 target01 = new TargetEx01();
		Runnable target02 = new TargetEx02();  // 위 사항과 아래사항과 같다.
		Thread threadA = new Thread(target01, "A");  // ,"A" 라는 이름을 줘도 안줘도 상관무. A 라는 이름의 쓰레드 생성 - target01.run() 을 수행하는 쓰레드.
		Thread threadB = new Thread(target02, "B");  // 위의 내용과 같다. 서로 다른 내용.
		threadA.start();  //둘중 누가 먼저 실행될지는 모른다.
		threadB.start();  // 실행가능한 상태.
		for(int i =0; i<10 ; i++) {
			System.out.println("나는 main 쓰레드"+Thread.currentThread().getName()); //지금 구동하는 스레드의 이름
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}//for
	}//main
}//class
