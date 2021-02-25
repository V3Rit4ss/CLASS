package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class Ex04Login extends Frame {
	private Panel panel;
	private TextField txtId, txtPw;
	private Button btnLogin;
	public Ex04Login(String title) {
		super(title);
		setLayout(new BorderLayout());  //안써도 되긴함. 왜냐하면 기본값이기때문.
		panel = new Panel(new GridLayout(2, 2)); // 단,()안에 ()에 넣기 아래처럼 해도댐.
		//panel.setLayout(new GridLayout(2, 2));
		txtId = new TextField("ID",20);
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("로그인");
		panel.add(new Label("아 이 디"));
		panel.add(txtId);
		panel.add(new Label("비밀번호"));
		panel.add(txtPw);
		add(panel, BorderLayout.NORTH);
		add(btnLogin, BorderLayout.SOUTH);
		
		setSize(new Dimension(400, 200));
	//	setLocation(0, 0);  //이거 안하면 이거의 기본값인 0,0 으로댐
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ex04Login("로그인 화면");
	}
	
}
