package com.lec.quiz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	private Container container;
	private JPanel jp;
	private JPanel jp2;
	private JPanel jp3;
	private JTextField jtxtName, jtxtTel, jtxtAge;
	private ImageIcon icon;
	private JButton btnIn;
	private JButton btnOut;
	private JButton btnExit;
	private ArrayList<Person> person;
	public MyFrame(String title) {
		super(title);
		person = new ArrayList<Person>();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		jp = new JPanel(new GridLayout(3, 2));
		jp2 = new JPanel(new FlowLayout());
		jp3 = new JPanel(new FlowLayout());
		jtxtName = new JTextField();
		jtxtTel = new JTextField();
		jtxtAge = new JTextField();
		icon = new ImageIcon("icon/In.and.Out3.jpg");
		btnIn = new JButton("�Է�", icon);
		btnOut = new JButton("���", icon);
		btnExit = new JButton("����");
		
		jp.add(new JLabel("��  ��",(int) CENTER_ALIGNMENT));
		jp.add(jtxtName);
		jp.add(new JLabel("��ȭ ��ȣ",(int) CENTER_ALIGNMENT));
		jp.add(jtxtTel);
		jp.add(new JLabel("��  ��",(int) CENTER_ALIGNMENT));
		jp.add(jtxtAge);
		jp2.add(btnIn);
		jp2.add(btnOut);
		jp3.add(btnExit);
		
		container.add(jp, BorderLayout.NORTH);
		container.add(jp2, BorderLayout.CENTER); //��ġ ���� //��ġ ����
		container.add(jp3, BorderLayout.SOUTH);
		setVisible(true);
		setSize(new Dimension(400, 300));
		setLocation(150,150);
		
		btnIn.addActionListener(this);//�̺�Ʈ ������
		btnOut.addActionListener(this); //   ``
		btnExit.addActionListener(this);//�̺�Ʈ ������
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnIn) {
			String name, tel; int age;
			name = jtxtName.getText().trim();
			tel = jtxtTel.getText().trim();
			
			try {
				age = Integer.parseInt(jtxtAge.getText());
			}catch(NumberFormatException exception) {
				age = -1;
			}
			if(!name.equals("") && !tel.equals("") && age != -1) {
				person.add(new Person(name, tel, age));
				jtxtName.setText("");
				jtxtTel.setText("");
				jtxtAge.setText("");
			}else {
				System.out.println("��ȿ �����ʴ� �Է��Դϴ�.");
			}
		}else if(e.getSource() == btnOut) {
			for(Person p: person) {
				System.out.println(p);
			}
		}else if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
			
			Writer writer = null;
			try {
				writer = new FileWriter("src/com/lec/ex02_swing/Person/txt1.txt",true);
				for(Person p: person)
					writer.write(p.toString()+"\r\n");
			}catch(IOException e1) {
				System.out.println(e1.getMessage());
				
			}finally {
				try {
					if(writer != null) writer.close();
				}catch(Exception e1) {
					
				}
			}
			
		}
		
	}
	public static void main(String[] args) {
		new MyFrame("����");
		
	}
	
}
