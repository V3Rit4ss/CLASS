package com.lec.ex01_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//1. implements ActionListener 2.해당 오버라이드. 3.생성자안에 btnExit.addActionListener(this);  4.이벤트 처리 메소드안에 내용 추가.
public class Ex02MyFrame extends Frame implements ActionListener {
	private Label lbl1;  //추가할 컴포넌트 변수들 선언
	private Button btnExit;
	
	public Ex02MyFrame() {
		//프레임에 라벨과 버튼 추가후 setVisible과 setSize
		//프레임의 레이아웃 스타일을 플로우레이아웃() 으로 - add 순서대로 차곡차곡.
		setLayout(new FlowLayout());
//		setLayout(new BorderLayout());  - 기본.
//		setLayout(new GridLayout(2, 2)); 2행 2열 짜리 격자 레이아웃.
		
		lbl1 = new Label("즐거운 월요일");
		lbl1.setPreferredSize(new Dimension(150, 200)); //컴포너트 사이즈.
		btnExit = new Button("종료");
		btnExit.setPreferredSize(new Dimension(200, 200));
		add(lbl1);//프레임에 넣는다.
		add(btnExit);
		setVisible(true);
		setSize(new Dimension(500, 300));
		setLocation(100, 100);
		//btnExit 클릭할시 이벤트 걸기.
		btnExit.addActionListener(this);  //클릭 이벤트 발생되면 this.actionPerformed(Exit)호출
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		
		
		
	}
	public Ex02MyFrame(String title) {
		this();
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) { //이벤트 처리 메소드
	//	btnExit 클릭 이벤트 발생되면 this.actionPerformed(Exit)호출
		if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new Ex02MyFrame("두번째 GUI 예제"); //여 밑에다가 메인함수 만들고 해도 되고 메인클래스 만들어서 해도 되고.
	}
	
	
}
