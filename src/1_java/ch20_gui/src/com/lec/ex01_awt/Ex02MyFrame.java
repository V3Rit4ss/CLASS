package com.lec.ex01_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//1. implements ActionListener 2.�ش� �������̵�. 3.�����ھȿ� btnExit.addActionListener(this);  4.�̺�Ʈ ó�� �޼ҵ�ȿ� ���� �߰�.
public class Ex02MyFrame extends Frame implements ActionListener {
	private Label lbl1;  //�߰��� ������Ʈ ������ ����
	private Button btnExit;
	
	public Ex02MyFrame() {
		//�����ӿ� �󺧰� ��ư �߰��� setVisible�� setSize
		//�������� ���̾ƿ� ��Ÿ���� �÷ο췹�̾ƿ�() ���� - add ������� ��������.
		setLayout(new FlowLayout());
//		setLayout(new BorderLayout());  - �⺻.
//		setLayout(new GridLayout(2, 2)); 2�� 2�� ¥�� ���� ���̾ƿ�.
		
		lbl1 = new Label("��ſ� ������");
		lbl1.setPreferredSize(new Dimension(150, 200)); //������Ʈ ������.
		btnExit = new Button("����");
		btnExit.setPreferredSize(new Dimension(200, 200));
		add(lbl1);//�����ӿ� �ִ´�.
		add(btnExit);
		setVisible(true);
		setSize(new Dimension(500, 300));
		setLocation(100, 100);
		//btnExit Ŭ���ҽ� �̺�Ʈ �ɱ�.
		btnExit.addActionListener(this);  //Ŭ�� �̺�Ʈ �߻��Ǹ� this.actionPerformed(Exit)ȣ��
		
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
	public void actionPerformed(ActionEvent e) { //�̺�Ʈ ó�� �޼ҵ�
	//	btnExit Ŭ�� �̺�Ʈ �߻��Ǹ� this.actionPerformed(Exit)ȣ��
		if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new Ex02MyFrame("�ι�° GUI ����"); //�� �ؿ��ٰ� �����Լ� ����� �ص� �ǰ� ����Ŭ���� ���� �ص� �ǰ�.
	}
	
	
}
