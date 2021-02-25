package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("title");
		Button btn = new Button("버튼");
		Button btn1 = new Button("그냥 버튼");  //이렇게 버튼을 입력하면 마지막에 한 것만 나온다.
		frame.add(btn, BorderLayout.NORTH); //위치를 결정하는.
		frame.add(btn1, BorderLayout.CENTER);
		frame.setSize(new Dimension(300,200)); //크기
		frame.setLocation(100, 50); //위치 x좌표 , y좌표
		frame.setVisible(true);  //반드시 트루로 해야 보임
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		frame.setVisible(false); //화면에서 안보이게 
		frame.dispose();// 프레임의 모든 자원을 해제
		System.exit(0);//강제종료
		
	}
}
