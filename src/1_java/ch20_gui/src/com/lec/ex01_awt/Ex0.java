package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("title");
		Button btn = new Button("��ư");
		Button btn1 = new Button("�׳� ��ư");  //�̷��� ��ư�� �Է��ϸ� �������� �� �͸� ���´�.
		frame.add(btn, BorderLayout.NORTH); //��ġ�� �����ϴ�.
		frame.add(btn1, BorderLayout.CENTER);
		frame.setSize(new Dimension(300,200)); //ũ��
		frame.setLocation(100, 50); //��ġ x��ǥ , y��ǥ
		frame.setVisible(true);  //�ݵ�� Ʈ��� �ؾ� ����
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		frame.setVisible(false); //ȭ�鿡�� �Ⱥ��̰� 
		frame.dispose();// �������� ��� �ڿ��� ����
		System.exit(0);//��������
		
	}
}
