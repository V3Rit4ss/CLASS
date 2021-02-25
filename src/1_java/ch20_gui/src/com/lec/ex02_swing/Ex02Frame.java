package com.lec.ex02_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex02Frame extends JFrame implements ActionListener {
//	private JPanel jPanel; //컨테이너 얻어와서 받을 변수  둘중 하나만 써도 댐
	private Container container; // 컨데이너 얻어와서 받을 변수
	private JLabel jl;
	private ImageIcon icon;
	private JButton jbtn;
	private JTextField jtxtField;
	private Vector<String> item; // 컴보박스에 들어갈 리스트
	private String[] items = { "A", "B", "C" }; // 컴보박스에 들어갈 리스트를 배열로 쓰기.
	private JComboBox<String> jcombo;
	private JCheckBox jcheck;
	private JLabel jlblank;
	private JButton jbtnExit;

	public Ex02Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 윈도우 창의 x버튼을 누르면 꺼지게끔 하는 녀석.
		container = getContentPane(); // 컨테이너 얻어오기.
//		jPanel = (JPanel) getContentPane(); 어제 컨테이너 얻어온 방식
		container.setLayout(new FlowLayout()); // 레이아웃 셋팅
		// jPanel.setLayout(new FlowLayout());
		jl = new JLabel("Label");
		icon = new ImageIcon("icon/write.gif");
		jbtn = new JButton("Button", icon);
		jtxtField = new JTextField(20);
		item = new Vector<String>(); // 컴보박스 안에 들어갈 리스트.
		item.add("A");
		item.add("B");
		item.add("C"); // 그 컴보박스 리스트 안에 들어갈 변수들.
		jcombo = new JComboBox<String>(item);// 벡터로 생성해도 댐. 근데 대부분 벡터로 함.
//		jcombo = new JComboBox<String>(items); //배열로 생성해도 담.
		jcheck = new JCheckBox("checkBox"); // 체크박스안에 넣을 이름
		jlblank = new JLabel();
		jbtnExit = new JButton("Exit");
		// = new 하는건 컨테이너나 패널위에 생성하게 하는것.

		// 컴포넌트들의 크기조정
		jl.setPreferredSize(new Dimension(50, 50));
		jbtn.setPreferredSize(new Dimension(200, 50));
		jtxtField.setPreferredSize(new Dimension(300, 50));
		jcombo.setPreferredSize(new Dimension(100, 50));
		jcheck.setPreferredSize(new Dimension(100, 50));
		jlblank.setPreferredSize(new Dimension(200, 50));
		jbtnExit.setPreferredSize(new Dimension(100, 50));

		container.add(jl);
		container.add(jbtn);
		container.add(jtxtField);
		container.add(jcombo);
		container.add(jcheck);
		container.add(jlblank);
		container.add(jbtnExit);
		setVisible(true);
		pack(); // 컴포넌트들이 배치될수있는 최소한의 화면 사이즈.
		// 이벤트 리스너 추가
		jbtn.addActionListener(this);
		jcombo.addActionListener(this);
		jcheck.addActionListener(this);
		jbtnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트 로직 추가.
		if (e.getSource() == jbtn) {
			String temp = jtxtField.getText().trim();
			if (!temp.equals("")) {// 빈 칸과 템프가 같지않다면. temp.equals("")) return;
				jlblank.setText(temp); // 템포를 빈칸(jlblank)에 넣고 j콤보 추가
				jcombo.addItem(temp);
				System.out.println(item); // 컴보박스에 추가하면 item도 추가
				jtxtField.setText(""); // 빈칸으로 만듬.
				String name = JOptionPane.showInputDialog("이름은?");
				if (name != null) {
					jcheck.setText(name);
				}

			}
		} else if (e.getSource() == jcombo) {
			jlblank.setText(jcombo.getSelectedItem().toString());
		} else if (e.getSource() == jcheck) {
			if (jcheck.isSelected()) { // 체크박스를 체크했는지의 여부
				jlblank.setText(jcheck.getText());
			} else {
				System.out.println("체크박스를 언체크함.");
			}
		} else if (e.getSource() == jbtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Ex02Frame("스윙");
	}

}
