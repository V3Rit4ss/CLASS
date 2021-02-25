package com.lec.ex01_awt; //집가서 하기.

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
		btnScissors = new Button("가위");
		btnRock = new Button("바위");
		btnPaper = new Button("보");
		btnRemove = new Button("지우기");
		btnExit = new Button("종료");
		list = new List(5); //5줄 부터 스크롤바 생기는.

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
		if (e.getSource() == btnScissors) { //가위.
			switch (computer) {
			case 0:
				list.add("비김, 서로 같은 것을 냈습니다.");
			case 1:
				list.add("컴퓨터가 이김. 당신은 가위, 컴퓨터는 바위"); 
				break;
			case 2:
				list.add("컴퓨터가 짐. 당신은 가위 , 컴퓨터는 보 ");
				break;
			}
			
			
		} else if (e.getSource() == btnRock) {
			switch (computer) {
			case 0:
				
				list.add("비김. 서로 같은 것을 냈습니다.");
				break;
			case 1:
				list.add("당신이 이김. 당신은 바위, 컴퓨터는 바위");
				break;
			case 2:
				list.add("컴퓨터가 이김. 당신은 바위, 컴퓨터는 보");
				break;
			}
		}else if(e.getSource() == btnPaper) {
			switch (computer) {
			case 0:
				list.add("비김. 서로 같은것을 냈습니다.");
				break;
			case 1:
				list.add("당신이 이김. 당신은 보, 컴퓨터는 바위");
				break;
			case 2:
				list.add("컴퓨터가 이김. 당신은 보, 컴퓨터는 가위");
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
		new Ex06RockScissorsPaper("가위바위보 게임.");
	}
	
}
