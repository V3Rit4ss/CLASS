package com.lec.ex02_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;  //�� J �� ������.
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex01Frame extends JFrame implements ActionListener {//�̳༮�� �������� ���������ִ�.
	private JPanel panel;
	private JLabel jlbl;
	private JButton btn;
	
	public Ex01Frame(String title) {  //Ÿ��Ʋ ������ ������ ��Ʈ�� Ÿ��Ʋ. �ϰ� ���� �߰�.
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);  //������ ���.  ������â�� x�� ������ �����.
		panel = (JPanel) getContentPane();  // �����̳�(������ : ȭ�� ��ü)�� ����
		panel.setLayout(new FlowLayout());  //�̰� �߰��������. �� �г��� border���̾ƿ��� ������ �����ͼ� �׷�.
		jlbl = new JLabel("��ſ� ������", (int)CENTER_ALIGNMENT);
		jlbl.setPreferredSize(new Dimension(150, 200));
		btn = new JButton("����");  
		btn.setPreferredSize(new Dimension(200, 200)); //������ ũ��� �������
		panel.add(jlbl);
		panel.add(btn); //��������� ������ �ϼ�.
		setVisible(true);
//		pack();  //�ּ����� ����� �ڵ����� �����.
		setSize(new Dimension(500, 300));
		setVisible(true);
		
		//�̺�Ʈ �߰�. ��ư Ȱ��ȭ.  (������ �߰�.)
		btn.addActionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	
	
	public static void main(String[] args) {
		new Ex01Frame("ù ���� ����");
	}


	
	
	
	
}
