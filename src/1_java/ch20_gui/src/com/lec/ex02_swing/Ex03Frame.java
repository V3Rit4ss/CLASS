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

	private Container container; // ��ü �����̳ʸ� �޾ƿ� ����
	private JPanel jp;
	private JTextField jtxtName, jtxtTel, jtxtAge;
	private ImageIcon icon;
	private JButton btnOut;
	private JTextArea jta; // ������ �Է� ������.
	private JScrollPane scrollbar; // ��ũ�ѹ� ���� ������.

	public Ex03Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x��ư ������ ����.
		container = getContentPane();
		// �����̳�.�·��̾ƿ�(�� �������̾ƿ�()); �̰� �⺻���̶� ���� ����.
		jp = new JPanel(new GridLayout(3, 2));
		jtxtName = new JTextField(); // �ƹ� ũ�������� ���ϸ� �ڵ������� �����.
		jtxtTel = new JTextField();
		jtxtAge = new JTextField();
		icon = new ImageIcon("icon/output.png");
		btnOut = new JButton("���", icon);
		// ��ũ�ѹٸ� ����� �ؽ�Ʈ �ʵ� �ض�.
		jta = new JTextArea(5, 30); // ����30�Է� ����5��
		scrollbar = new JScrollPane(jta); // ��ũ�ѹ� (jta) �� �־�� ��ũ�ѹٰ� ����.

		jp.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT));
		jp.add(jtxtName);
		jp.add(new JLabel("��  ȭ", (int) CENTER_ALIGNMENT));
		jp.add(jtxtTel);
		jp.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT));
		jp.add(jtxtAge);
		container.add(jp, BorderLayout.NORTH);
		container.add(btnOut, BorderLayout.CENTER);
		container.add(scrollbar, BorderLayout.SOUTH);
		setVisible(true);
//		setSize(new Dimension(400, 300));
//		setLocation(100, 100);    �»������ �� �����̼� �ΰ��� ���ÿ� �ϴ°� �¹ٿ��'s
		setBounds(100, 100, 400, 300);

		btnOut.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOut) {
			String name = jtxtName.getText().trim();
			String tel = jtxtTel.getText().trim();
			if (name.equals("") || tel.equals("")) { // if(!name.equals("") && !tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �ݵ�� �Է�"); // int age; jtxtAge.getText(); // ��Ʈ�����̶� ��Ʈ ���Ѹ���.
				return;										// ������ ������.
			}
			int age;
			try {
				age = Integer.parseInt(jtxtAge.getText());
			} catch (NumberFormatException ex) { // ex = excpetion
				age = -1;
			}
			String result = "[�̸�]" + name + "\t[��ȭ]" + tel;
			if (age >= 0 && age < 130) {
				result += "\t[����]" + age;
			} else {
				result += "\t[����] ��ȿ���� �ʴ� ���̸� �Է��߽��ϴ�.";
			}
			System.out.println(result);
			jta.append(result + "\r\n");
			jtxtName.setText("");
			jtxtTel.setText("");
			jtxtAge.setText("");
		}

	}

	public static void main(String[] args) {
		new Ex03Frame("GUI ����");
	}
}
