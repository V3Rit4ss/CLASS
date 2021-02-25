package com.lec.ex01_awt;

import java.awt.*;

public class Ex03Login extends Frame {
	private Label lbl1;
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;
	public Ex03Login(String title) {
		super(title);
		setLayout(new FlowLayout()); // 프레임의 레이아웃 셋팅. 에드하는 순서대로 차곡차곡.
		lbl1 = new Label("아 이 디");
		txtId = new TextField("ID", 20);   //,20 : 사이즈 크기.
		lbl2 = new Label("비밀번호");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("로그인");
		add(lbl1);    //add(new Label("아 이 디")); 이렇게도 한다. 대신 위에 선언한거 없애야함
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		setSize(new Dimension(300, 150));
		setResizable(false); // 사용자가 프레임 사이즈 조정 불가.
		setLocation(100, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex03Login("로그인 화면"); //프레임 타이틀 이름.
	}
	
}
