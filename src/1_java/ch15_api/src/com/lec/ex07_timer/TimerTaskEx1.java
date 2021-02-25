package com.lec.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx1 extends TimerTask {
	//오버라이드 함수 run에 작업정의를 한다.
	@Override
	public void run() {
		System.out.println("★★★★★★작업1 : 2초후에 한번 timer 걸 예정");
		
	}

}
