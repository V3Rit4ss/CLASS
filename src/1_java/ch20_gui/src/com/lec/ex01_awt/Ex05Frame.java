package com.lec.ex01_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//1.���ø���Ʈ ActionListener  2. �װſ� �ش��ϴ� �������̵�.
public class Ex05Frame extends Frame implements ActionListener { 
	private Panel panel ;
	private TextField txtField;
	private Button btnOk;
	private Button btnExit;
	private List list;
	
	public Ex05Frame () {
		//���̾ƿ����� , ������Ʈ ���� �� add, setVisble , setSize ~~
//		super(title);
		setLayout(new BorderLayout()); // �⺻���̶� ��������.
		panel = new Panel(new FlowLayout());  //�г��� �÷ο췹�̾ƿ��� �⺻�̶� ���ص� ��. panel = new Panel();
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();   //�ȸ��� ���ϸ� �ش� �����ŭ ������.
		
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400, 200));
		//2. �̺�Ʈ ������ �߰�
		//3. ���� �߰�
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk) {
			//txtField �� �ؽ�Ʈ�� list �� �߰��ϰ� txtField �� ""
			list.add(txtField.getText());
			txtField.setText("");
		}else if(e.getSource() == btnExit) {
			//����.
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new  Ex05Frame();    //����(title); �� �ϸ� Ÿ��Ʋ �̸� �ھƳֱ� ����.
	}
	
}
