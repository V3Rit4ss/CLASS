package com.lec.ex02_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex03Frame extends JFrame implements ActionListener {

	private Container container; // 전체 컨테이너를 받아올 변수
	private JPanel jp;
	private JTextField jtxtName, jtxtTel, jtxtAge;
	private ImageIcon icon;
	private JButton btnOut;
	private JTextArea jta; // 여러줄 입력 가능한.
	private JScrollPane scrollbar; // 스크롤바 생성 가능한.

	public Ex03Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x버튼 누르면 종료.
		container = getContentPane();
		// 컨테이너.셋레이아웃(뉴 보더레이아웃()); 이건 기본값이라 생략 가능.
		jp = new JPanel(new GridLayout(3, 2));
		jtxtName = new JTextField(); // 아무 크기조정을 안하면 자동적으로 잡아줌.
		jtxtTel = new JTextField();
		jtxtAge = new JTextField();
		icon = new ImageIcon("icon/output.png");
		btnOut = new JButton("출력", icon);
		// 스크롤바를 만들고 텍스트 필드 해라.
		jta = new JTextArea(5, 30); // 가로30입력 세로5줄
		scrollbar = new JScrollPane(jta); // 스크롤바 (jta) 를 넣어야 스크롤바가 생김.

		jp.add(new JLabel("이  름", (int) CENTER_ALIGNMENT));
		jp.add(jtxtName);
		jp.add(new JLabel("전  화", (int) CENTER_ALIGNMENT));
		jp.add(jtxtTel);
		jp.add(new JLabel("나  이", (int) CENTER_ALIGNMENT));
		jp.add(jtxtAge);
		container.add(jp, BorderLayout.NORTH);
		container.add(btnOut, BorderLayout.CENTER);
		container.add(scrollbar, BorderLayout.SOUTH);
		setVisible(true);
//		setSize(new Dimension(400, 300));
//		setLocation(100, 100);    셋사이즈와 셋 로케이션 두개를 동시에 하는것 셋바운드's
		setBounds(100, 100, 400, 300);

		btnOut.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOut) {
			String name = jtxtName.getText().trim();
			String tel = jtxtTel.getText().trim();
			if (name.equals("") || tel.equals("")) { // if(!name.equals("") && !tel.equals("")) {
				System.out.println("이름과 전화번호는 반드시 입력"); // int age; jtxtAge.getText(); // 스트링값이라 인트 제한못함.
				return;										// 리턴은 빼야함.
			}
			int age;
			try {
				age = Integer.parseInt(jtxtAge.getText());
			} catch (NumberFormatException ex) { // ex = excpetion
				age = -1;
			}
			String result = "[이름]" + name + "\t[전화]" + tel;
			if (age >= 0 && age < 130) {
				result += "\t[나이]" + age;
			} else {
				result += "\t[나이] 유효하지 않는 나이를 입력했습니다.";
			}
			System.out.println(result);
			jta.append(result + "\r\n");
			jtxtName.setText("");
			jtxtTel.setText("");
			jtxtAge.setText("");
		}

	}

	public static void main(String[] args) {
		new Ex03Frame("GUI 예제");
	}
}
