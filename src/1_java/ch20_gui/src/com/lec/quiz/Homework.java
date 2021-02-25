package com.lec.quiz;

//������
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Homework extends JFrame implements ActionListener {
	private Container container;
	private JPanel jp, jp2;
	private JTextField jtxtName, jtxtTel, jtxtPoint;
	private JTextArea jta;
	private JScrollPane scrollbar;
	private JButton SignUp;
	private JButton TelSearch;
	private JButton btnOut;
	private JButton btnExit;
	private HashMap<String, Customer> customers;

	public Homework(String title) {
		super(title);
		customers = new HashMap<String, Customer>();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();// �����̳� ������
		container.setLayout(new FlowLayout());
		jp = new JPanel(new GridLayout(3, 2));
		jp2 = new JPanel(new FlowLayout());
		jtxtName = new JTextField(15);
		jtxtTel = new JTextField(15);
		jtxtPoint = new JTextField(15);
		SignUp = new JButton("����");
		TelSearch = new JButton("��ȣ ��ȸ");
		btnOut = new JButton("���");
		btnExit = new JButton("����");
		jta = new JTextArea(15, 30);
		scrollbar = new JScrollPane(jta);

		jp.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT));
		jp.add(jtxtName);
		jp.add(new JLabel("��ȭ ��ȣ", (int) CENTER_ALIGNMENT));
		jp.add(jtxtTel);
		jp.add(new JLabel("�� �� Ʈ", (int) CENTER_ALIGNMENT));
		jp.add(jtxtPoint);
		jp2.add(SignUp);
		jp2.add(TelSearch);
		jp2.add(btnOut);
		jp2.add(btnExit);
		container.add(jp, BorderLayout.NORTH);
		container.add(jp2, BorderLayout.CENTER);
		container.add(scrollbar, BorderLayout.SOUTH);
		setVisible(true);
		setBounds(150, 150, 400, 450);

		SignUp.addActionListener(this);
		TelSearch.addActionListener(this);
		btnOut.addActionListener(this);
		btnExit.addActionListener(this);

	}

	public Homework() {
		this("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SignUp) {
			String name, tel;
			int point = 1000;
			name = jtxtName.getText().trim();
			tel = jtxtTel.getText().trim();
			try {
				point = Integer.parseInt(jtxtTel.getText()); // ��Ʈ�� �� ������ ��ȯ�ϴ�.
			} catch (Exception exception) {
			}
			int preIdx = tel.indexOf("-");
			int postIdx = tel.lastIndexOf("-");
			if (!name.equals("") && !tel.equals("") && preIdx < postIdx) {

				Customer newCustomer = new Customer(name, tel, point);
				customers.put(tel, newCustomer);
				System.out.println(newCustomer + "���� ����");
				jta.append(newCustomer.toString() + "\r\n");
				// jta.setText(jta.getText()+newCustomer.toString()+"\r\n");
				jtxtName.setText("");
				jtxtTel.setText("");
				jtxtPoint.setText("1000");
			} // if
		} else if (e.getSource() == TelSearch) {

			// �ؽ����� �̿�.
			String searchPhone = jtxtTel.getText().trim();
			int cnt = 0;
			Iterator<String> iterator = customers.keySet().iterator();
			while (iterator.hasNext()) {
				String tel = iterator.next();
				String postTel = tel.substring(tel.lastIndexOf('-') + 1);
				if (postTel.equals(searchPhone)) {
					jtxtTel.setText(customers.get(tel).getTel());
					jtxtName.setText(customers.get(tel).getName());
					jtxtPoint.setText(String.valueOf(customers.get(tel).getPoint()));
					break;
				}
				cnt++;

			}
			if (cnt == customers.size()) {
				jtxtName.setText("���� ȸ���Դϴ�.");
				jtxtTel.setText("");
				jtxtPoint.setText("1000��");
			}
		}else if(e.getSource()==btnOut) {
			
			OutputStream os = null;
			PrintWriter printWriter = null;
			try {
				os = new FileOutputStream("src\\com\\lec\\quiz\\customer2.txt", true);
				printWriter = new PrintWriter(os);
				Iterator<String> iterator = customers.keySet().iterator();
				while (iterator.hasNext()) {
					String tempTel = iterator.next();
					printWriter.println(customers.get(tempTel).toString());
				}
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (printWriter != null)
						printWriter.close();
					if (os != null)
						os.close();
				}catch (IOException e2) {
					
				}
}
		}else if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}//action �̺�Ʈ 
	public static void main(String[] args) {
		new Homework("ȸ�� ����");
	}
}