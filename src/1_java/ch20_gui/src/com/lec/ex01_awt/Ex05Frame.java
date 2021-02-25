package com.lec.ex01_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//1.임플리먼트 ActionListener  2. 그거에 해당하는 오버라이드.
public class Ex05Frame extends Frame implements ActionListener { 
	private Panel panel ;
	private TextField txtField;
	private Button btnOk;
	private Button btnExit;
	private List list;
	
	public Ex05Frame () {
		//레이아웃셋팅 , 컴포넌트 생성 후 add, setVisble , setSize ~~
//		super(title);
		setLayout(new BorderLayout()); // 기본값이라 생략가능.
		panel = new Panel(new FlowLayout());  //패널은 플로우레이아웃이 기본이라 안해도 댐. panel = new Panel();
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();   //안말도 안하면 해당 사이즈만큼 맞춰줌.
		
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400, 200));
		//2. 이벤트 리스너 추가
		//3. 로직 추가
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk) {
			//txtField 의 텍스트를 list 로 추가하고 txtField 는 ""
			list.add(txtField.getText());
			txtField.setText("");
		}else if(e.getSource() == btnExit) {
			//종료.
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new  Ex05Frame();    //슈퍼(title); 를 하면 타이틀 이름 박아넣기 가능.
	}
	
}
