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
		setLayout(new FlowLayout()); // �������� ���̾ƿ� ����. �����ϴ� ������� ��������.
		lbl1 = new Label("�� �� ��");
		txtId = new TextField("ID", 20);   //,20 : ������ ũ��.
		lbl2 = new Label("��й�ȣ");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("�α���");
		add(lbl1);    //add(new Label("�� �� ��")); �̷��Ե� �Ѵ�. ��� ���� �����Ѱ� ���־���
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		setSize(new Dimension(300, 150));
		setResizable(false); // ����ڰ� ������ ������ ���� �Ұ�.
		setLocation(100, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex03Login("�α��� ȭ��"); //������ Ÿ��Ʋ �̸�.
	}
	
}
