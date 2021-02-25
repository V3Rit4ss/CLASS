package com.lec.ex02_thread;

public class TargetEx02 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("¹Ý°©½À´Ï´Ù.."+i);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
			}
		}
	}

}
