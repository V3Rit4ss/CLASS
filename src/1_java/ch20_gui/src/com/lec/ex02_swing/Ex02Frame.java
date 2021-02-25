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
//	private JPanel jPanel; //�����̳� ���ͼ� ���� ����  ���� �ϳ��� �ᵵ ��
	private Container container; // �����̳� ���ͼ� ���� ����
	private JLabel jl;
	private ImageIcon icon;
	private JButton jbtn;
	private JTextField jtxtField;
	private Vector<String> item; // �ĺ��ڽ��� �� ����Ʈ
	private String[] items = { "A", "B", "C" }; // �ĺ��ڽ��� �� ����Ʈ�� �迭�� ����.
	private JComboBox<String> jcombo;
	private JCheckBox jcheck;
	private JLabel jlblank;
	private JButton jbtnExit;

	public Ex02Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ������ â�� x��ư�� ������ �����Բ� �ϴ� �༮.
		container = getContentPane(); // �����̳� ������.
//		jPanel = (JPanel) getContentPane(); ���� �����̳� ���� ���
		container.setLayout(new FlowLayout()); // ���̾ƿ� ����
		// jPanel.setLayout(new FlowLayout());
		jl = new JLabel("Label");
		icon = new ImageIcon("icon/write.gif");
		jbtn = new JButton("Button", icon);
		jtxtField = new JTextField(20);
		item = new Vector<String>(); // �ĺ��ڽ� �ȿ� �� ����Ʈ.
		item.add("A");
		item.add("B");
		item.add("C"); // �� �ĺ��ڽ� ����Ʈ �ȿ� �� ������.
		jcombo = new JComboBox<String>(item);// ���ͷ� �����ص� ��. �ٵ� ��κ� ���ͷ� ��.
//		jcombo = new JComboBox<String>(items); //�迭�� �����ص� ��.
		jcheck = new JCheckBox("checkBox"); // üũ�ڽ��ȿ� ���� �̸�
		jlblank = new JLabel();
		jbtnExit = new JButton("Exit");
		// = new �ϴ°� �����̳ʳ� �г����� �����ϰ� �ϴ°�.

		// ������Ʈ���� ũ������
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
		pack(); // ������Ʈ���� ��ġ�ɼ��ִ� �ּ����� ȭ�� ������.
		// �̺�Ʈ ������ �߰�
		jbtn.addActionListener(this);
		jcombo.addActionListener(this);
		jcheck.addActionListener(this);
		jbtnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// �̺�Ʈ ���� �߰�.
		if (e.getSource() == jbtn) {
			String temp = jtxtField.getText().trim();
			if (!temp.equals("")) {// �� ĭ�� ������ �����ʴٸ�. temp.equals("")) return;
				jlblank.setText(temp); // ������ ��ĭ(jlblank)�� �ְ� j�޺� �߰�
				jcombo.addItem(temp);
				System.out.println(item); // �ĺ��ڽ��� �߰��ϸ� item�� �߰�
				jtxtField.setText(""); // ��ĭ���� ����.
				String name = JOptionPane.showInputDialog("�̸���?");
				if (name != null) {
					jcheck.setText(name);
				}

			}
		} else if (e.getSource() == jcombo) {
			jlblank.setText(jcombo.getSelectedItem().toString());
		} else if (e.getSource() == jcheck) {
			if (jcheck.isSelected()) { // üũ�ڽ��� üũ�ߴ����� ����
				jlblank.setText(jcheck.getText());
			} else {
				System.out.println("üũ�ڽ��� ��üũ��.");
			}
		} else if (e.getSource() == jbtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Ex02Frame("����");
	}

}
