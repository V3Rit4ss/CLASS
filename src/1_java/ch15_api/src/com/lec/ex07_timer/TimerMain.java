package com.lec.ex07_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(); //true 넣는이유 : 프로그램 종료되면 timer 종료
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000); // 2초후부터 2초마다
		timer.schedule(task2, 500, 1000); //0.5초 후부터 1초마다 실행
		Thread.sleep(10000); //10초 대기. //에러가 날수도있으니 뜨는거임.
		System.out.println("끝");
		
		
		
	}
}
