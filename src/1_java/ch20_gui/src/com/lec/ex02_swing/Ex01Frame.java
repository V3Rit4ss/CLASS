package com.lec.ex02_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;  //다 J 를 붙힌다.
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex01Frame extends JFrame implements ActionListener {//이녀석은 아이콘을 넣을수가있다.
	private JPanel panel;
	private JLabel jlbl;
	private JButton btn;
	
	public Ex01Frame(String title) {  //타이틀 붙히고 싶으면 스트링 타이틀. 하고 슈퍼 추가.
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);  //윈도우 어뎁터.  윈도우창의 x를 누르면 종료댐.
		panel = (JPanel) getContentPane();  // 컨테이너(프레임 : 화면 전체)를 얻어옴
		panel.setLayout(new FlowLayout());  //이거 추가해줘야함. 이 패널은 border레이아웃의 성질을 가져와서 그럼.
		jlbl = new JLabel("즐거운 월요일", (int)CENTER_ALIGNMENT);
		jlbl.setPreferredSize(new Dimension(150, 200));
		btn = new JButton("종료");  
		btn.setPreferredSize(new Dimension(200, 200)); //아이콘 크기와 맞춰야함
		panel.add(jlbl);
		panel.add(btn); //여기까지가 프레임 완성.
		setVisible(true);
//		pack();  //최소한의 사이즈를 자동으로 잡아줌.
		setSize(new Dimension(500, 300));
		setVisible(true);
		
		//이벤트 추가. 버튼 활성화.  (리스너 추가.)
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
		new Ex01Frame("첫 스윙 예제");
	}


	
	
	
	
}
