package com.lec.ex01_awt; //������ �ϱ�.

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex06RockScissorsPaper extends Frame implements ActionListener {
	private Panel panel;
	private TextField txtField;
	private Button btnRock;
	private Button btnScissors;
	private Button btnPaper;
	private Button btnExit;
	private Button btnRemove;
	private List list;

	public Ex06RockScissorsPaper(String title) {
		super(title);
		setLayout(new BorderLayout());
		panel = new Panel(new FlowLayout());
		btnScissors = new Button("����");
		btnRock = new Button("����");
		btnPaper = new Button("��");
		btnRemove = new Button("�����");
		btnExit = new Button("����");
		list = new List(5); //5�� ���� ��ũ�ѹ� �����.

		panel.add(btnScissors);
		panel.add(btnRock);
		panel.add(btnPaper);
		panel.add(btnRemove);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		add(btnExit, BorderLayout.SOUTH);
		setVisible(true);
		setSize(new Dimension(300, 150));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
			
		});
		btnRock.addActionListener(this);
		btnPaper.addActionListener(this);
		btnScissors.addActionListener(this);
		btnRemove.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int computer = (int)(Math.random()*3);
		if (e.getSource() == btnScissors) { //����.
			switch (computer) {
			case 0:
				list.add("���, ���� ���� ���� �½��ϴ�.");
			case 1:
				list.add("��ǻ�Ͱ� �̱�. ����� ����, ��ǻ�ʹ� ����"); 
				break;
			case 2:
				list.add("��ǻ�Ͱ� ��. ����� ���� , ��ǻ�ʹ� �� ");
				break;
			}
			
			
		} else if (e.getSource() == btnRock) {
			switch (computer) {
			case 0:
				
				list.add("���. ���� ���� ���� �½��ϴ�.");
				break;
			case 1:
				list.add("����� �̱�. ����� ����, ��ǻ�ʹ� ����");
				break;
			case 2:
				list.add("��ǻ�Ͱ� �̱�. ����� ����, ��ǻ�ʹ� ��");
				break;
			}
		}else if(e.getSource() == btnPaper) {
			switch (computer) {
			case 0:
				list.add("���. ���� �������� �½��ϴ�.");
				break;
			case 1:
				list.add("����� �̱�. ����� ��, ��ǻ�ʹ� ����");
				break;
			case 2:
				list.add("��ǻ�Ͱ� �̱�. ����� ��, ��ǻ�ʹ� ����");
				break;
			}
		}else if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);

		}else if(e.getSource() == btnRemove) {
			list.removeAll();
		}

	}
	
	public static void main(String[] args) {
		new Ex06RockScissorsPaper("���������� ����.");
	}
	
}
