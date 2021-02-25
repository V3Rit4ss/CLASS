package com.lec.supermarket;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lec.studentGUI.StudentSwingDao;

public class SupermarketGUI extends JFrame implements ActionListener {
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField jtxtID, jtxtTel, jtxtName, jtxtPoint, jtxtAmount;
	private Vector<String> levels;
	private JComboBox<String> jcomLevel;
	private JButton jbtnIDsearch, jbtnTelSearch, jbtnNameSearch, jbtnBuyWhitPoint;
	private JButton jbtnBuy, jbtnLevelOutput, jbtnAllOutput, jbtnInsert, jbtnTelUpdate, jbtnDelete, jbtnExit;
	private JTextArea jtxtPool;
	private JScrollPane scrollPane;
	private String direver;
	private String url;
	SupermarketDao dao = SupermarketDao.getInstance();

	public SupermarketGUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel(new FlowLayout());
		jtxtID = new JTextField(20);
		jtxtTel = new JTextField(20);
		jtxtName = new JTextField(20);
		jtxtPoint = new JTextField(20);
		jtxtAmount = new JTextField(20);
		levels = new Vector<String>();
		levels = dao.getLevelNames();
		jcomLevel = new JComboBox<String>(levels);
		jbtnIDsearch = new JButton("���̵� �˻�");
		jbtnTelSearch = new JButton("��ȭ��ȣ ���ڸ�(�Ǵ� ��ü) �˻�");
		jbtnNameSearch = new JButton("�� �̸� �˻�");
		jbtnBuyWhitPoint = new JButton("����Ʈ�θ� ����");
		jpup.add(new JLabel(" �� �� �� ", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtID);
		jpup.add(jbtnIDsearch);
		jpup.add(new JLabel("�� �� �� ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtTel);
		jpup.add(jbtnTelSearch);
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtName);
		jpup.add(jbtnNameSearch);
		jpup.add(new JLabel("��  ��  Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtPoint);
		jpup.add(jbtnBuyWhitPoint);
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtAmount);
		jpup.add(new JLabel(""));// �� �� �߰��ϴ� �κ�
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(jcomLevel);
		jbtnBuy = new JButton("��ǰ ����");
		jbtnLevelOutput = new JButton("��޺����");
		jbtnAllOutput = new JButton("��ü���");
		jbtnInsert = new JButton("ȸ������");
		jbtnTelUpdate = new JButton("��ȣ����");
		jbtnDelete = new JButton("ȸ��Ż��");
		jbtnExit = new JButton("������");
		jpbtn.add(jbtnBuy);
		jpbtn.add(jbtnLevelOutput);
		jpbtn.add(jbtnAllOutput);
		jpbtn.add(jbtnInsert);
		jpbtn.add(jbtnTelUpdate);
		jpbtn.add(jbtnDelete);
		jpbtn.add(jbtnExit);
		jtxtPool = new JTextArea(6, 60);
		scrollPane = new JScrollPane(jtxtPool);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);
		setSize(new Dimension(750, 370));
		setLocation(200, 200);
		setVisible(true);
		jtxtPool.setText("\t�� �� �� ���˻� �� �����ϼ��� �� �� ��");

		jbtnIDsearch.addActionListener(this);
		jbtnTelSearch.addActionListener(this);
		jbtnNameSearch.addActionListener(this);
		jbtnBuyWhitPoint.addActionListener(this);
		jbtnBuy.addActionListener(this);
		jbtnLevelOutput.addActionListener(this);
		jbtnAllOutput.addActionListener(this);
		jbtnInsert.addActionListener(this);
		jbtnTelUpdate.addActionListener(this);
		jbtnDelete.addActionListener(this);
		jbtnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//���̵�˻�.
		if(e.getSource()== jbtnIDsearch) { 
			
			int cID  = 0;
			try {
				
				
				cID = Integer.parseInt(jtxtID.getText().trim());
				
			} catch (NumberFormatException e1) {
				
				jtxtPool.setText("ID�� �Է��� �˻� ���ּ���.");
			
				return;
			}
				
			SupermarketDto customer = dao.selectCID(cID);
			if(customer != null) {
				jtxtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� �߰� ������ �ݾ�\n");
				jtxtPool.append("��������������������������������������������������������������������\n");
				jtxtPool.append(customer.toString()+"\n");
				jtxtTel.setText(customer.getcTEL());
				jtxtName.setText(customer.getcNAME());
				jtxtPoint.setText(String.valueOf(customer.getcPOINT()));
				jtxtAmount.setText("");
				jcomLevel.setSelectedItem(customer.getLevelName());
			}else {
				
				jtxtPool.setText("�˻����� ���� ID�Դϴ�");
			}  
				
		} else if(e.getSource()==jbtnTelSearch) {// ID - if��. ��. TEL�˻� ����.
			String cTEL = jtxtTel.getText().trim();
			if(cTEL.length() < 4) {
				jtxtPool.setText("�ּ��� ��ȭ��ȣ �޹�ȣ 4�ڸ��� �Է����ֽð� �˻� ���ּ���.");
				return;
			} //if = �ּ����� ��ȣ�� �Է� �ߴ��� ����.
			
			ArrayList<SupermarketDto> customers = dao.selectCtel(cTEL);
			if(customers.size() >= 1 ) {
				jtxtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� �߰� ������ �ݾ�\n");
				jtxtPool.append("��������������������������������������������������������������������������������\n");
				for(SupermarketDto customer : customers) {
					jtxtPool.append(customer.toString()+"\n");
					jtxtID.setText(String.valueOf(customer.getcID()));
					jtxtTel.setText(customer.getcTEL());
					jtxtName.setText(customer.getcNAME());
					jtxtPoint.setText(String.valueOf(customer.getcPOINT()));
					jtxtAmount.setText("");
					jcomLevel.setSelectedItem(customer.getLevelName());
				}//for
				
				
			}else {
				jtxtPool.setText("�ش� ��ȭ��ȣ�� ���� �˻����� �ʽ��ϴ�, ���� ȸ�������� ���ּ���.");
				jtxtID.setText("");
				jtxtName.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
				
			}//if - catch dao.selectCtel(cTEL) 
			
			
		}else if(e.getSource()==jbtnNameSearch) { //���̸� �˻�.
			String cNAME = jtxtName.getText().trim();
			if(cNAME.length() == 0) {
				
				jtxtPool.setText(" �̸��� �Է��Ͻð� �˻��ϼ���");
				return;
			}// if - �̸��� �Է����� �������
			ArrayList<SupermarketDto> customers = dao.selectCName(cNAME);
			if(customers.size()>=1) {
				jtxtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� �߰� ������ �ݾ�\n");
				jtxtPool.append("��������������������������������������������������������������������������������\n");
				for(SupermarketDto customer : customers) {
					jtxtPool.append(customer.toString()+"\n");
					//jtxtID.setText(""+customer.getcId());
					jtxtID.setText(String.valueOf(customer.getcID()));
					jtxtTel.setText(customer.getcTEL());
					jtxtName.setText(customer.getcNAME());
					//jtxtPoint.setText(""+customer.getcPoint());
					jtxtPoint.setText(String.valueOf(customer.getcPOINT()));
					jtxtAmount.setText("");
					jcomLevel.setSelectedItem(customer.getLevelName());
				}//for
			}else {
				jtxtPool.setText(" ���̸��� �˻����� �ʽ��ϴ�. ȸ�������� ���ּ���");
				jtxtID.setText("");
				jtxtName.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
			}//if - catch dao.selectCName(cNAME)
			
			//����Ʈ�θ� ����.
		}else if(e.getSource()==jbtnBuyWhitPoint) {
			int cID = 0, cAMOUNT = 0, cPOINT = 0;
			try {
				cID = Integer.parseInt(jtxtID.getText().trim());
				cAMOUNT = Integer.parseInt(jtxtAmount.getText().trim());
				cPOINT = Integer.parseInt(jtxtPoint.getText().trim());
				if(cPOINT<cAMOUNT) {
					jtxtPool.setText("����Ʈ�� �����Ͽ� ����Ʈ�� ���� �Ұ����մϴ�");
					return;
				}
			}catch (NumberFormatException e1) {
				jtxtPool.setText("��ȿ�� ��ID�� ���űݾ��� �Է��Ͻð�, ���� ������ ����Ʈ�� �����ϼ���");
				return;
			}
			int result = dao.BuyWithPoint(cAMOUNT, cID);
			if (result==SupermarketDao.SUCCESS) {
				jtxtPool.setText("����Ʈ�� ���� ����");
				jtxtPoint.setText(String.valueOf(cPOINT-cAMOUNT));
				jtxtAmount.setText("");
			}else {
				jtxtPool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�");
			}// ����Ʈ ���� ��.
			
			//��ǰ����.
		}else if(e.getSource()==jbtnBuy) {
			int cID = 0, cAMOUNT = 0, cPOINT = 0;
			
			try {
				cID = Integer.parseInt(jtxtID.getText().trim());
				cAMOUNT = Integer.parseInt(jtxtAmount.getText().trim());
				cPOINT = Integer.parseInt(jtxtPoint.getText().trim());
			} catch (NumberFormatException e2) {
				jtxtPool.setText("��ȿ�� �� ���̵�� �����Ͻ� �ݾ��� �Է��Ͻð� ���Ÿ� ��Ź�帳�ϴ�.");
				return;
			}
			
			int result = dao.Buy(cAMOUNT, cID);
			if (result==SupermarketDao.SUCCESS) {
				jtxtPool.setText("��ǰ���� �� ��� ���� ����");
				jtxtPoint.setText(String.valueOf((int)(cPOINT+cAMOUNT*0.05)));
				jtxtAmount.setText("");
				
			}else {
				jtxtPool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�");
			}
			
			
			// ��޺����
		}else if(e.getSource()==jbtnLevelOutput) {
			
			jtxtID.setText("");
			jtxtTel.setText("");
			jtxtName.setText("");
			jtxtPoint.setText("");
			String levelName = jcomLevel.getSelectedItem().toString();
			if(levelName.equals("")) {
				jtxtPool.setText("���ϴ� ����� �����Ͻð� �˻��ϼ���");
				return;
			}// if - ��4�ڸ� �̻� �Է��ߴ���
			ArrayList<SupermarketDto> customers = dao.levelNames(levelName);
			if(customers.size() != 0 ) {
				jtxtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� �߰� ������ �ݾ�\n");
				jtxtPool.append("����������������������������������������������������������������������������������������������������������������\n");
				for(SupermarketDto customer : customers) {
					jtxtPool.append(customer.toString()+"\n");
				}//for
				jtxtPool.append("�� "+customers.size()+"��");
			}else {
				jtxtPool.setText("�ش� ������ ���� �˻����� �ʽ��ϴ�. ȸ������ �� �ּ���");
				
			}//��޺� ��� ��.
			
			
			
			//ȸ�� ��ü���.
		}else if(e.getSource()==jbtnAllOutput) {
			
			jtxtID.setText("");
			jtxtTel.setText("");
			jtxtName.setText("");
			jtxtPoint.setText("");
			jcomLevel.setSelectedIndex(0);
			ArrayList<SupermarketDto> customers = dao.selectCustomerAll();
			if(customers.size()!=0) {
				jtxtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� �߰� ������ �ݾ�\n");
				jtxtPool.append("����������������������������������������������������������������������������������������������������������������\n");
				for(SupermarketDto customer : customers) {
					jtxtPool.append(customer.toString()+"\n");
				}//for
				jtxtPool.append("�� "+customers.size()+"��");
			}else {
				jtxtPool.setText("������ ������ �����ϴ�.");
				
			}
			
			
			//ȸ������.
		}else if(e.getSource()==jbtnInsert) {
			jtxtID.setText("");
			jtxtAmount.setText("");	
			String cNAME = jtxtName.getText().trim();
			String cTEL = jtxtTel.getText().trim();
			if(cNAME.equals("")|| cTEL.equals("")) {
				jtxtPool.setText("ȸ�� ���Խ�, ����� ��ȭ��ȣ�� ���� �Է����ֽñ� �ٶ��ϴ�.");
				return;
			}
			jtxtPool.setText("");
			
			int result = dao.insertCustomer(cTEL, cNAME);
			if(result == SupermarketDao.SUCCESS) {
				jtxtPool.append(cNAME+"���� ȸ�������� ���ּż� �����մϴ� ! ����Ʈ 1000���� ȸ������ ������ �帳�ϴ�.");
				jtxtPoint.setText("1000");
				jcomLevel.setSelectedIndex(0);
			}
			
			//��ȭ��ȣ ����.
		}else if(e.getSource()==jbtnTelUpdate) {
			
			int cID= 0; String cTEL;
			try {
				cID = Integer.parseInt(jtxtID.getText().trim());
				cTEL = jtxtTel.getText().trim();
				if(cTEL.equals("")) {
					jtxtPool.setText("������ ��ȭ��ȣ�� �Է��ϼž� ��ȣ������ �����մϴ�.");
					return;
				}
			}catch (NumberFormatException e1) {
				jtxtPool.setText("��ȿ�� ��ID�� �˻� �� ��ȣ������ �ϼ���");
				return;
			}
			int result = dao.updatecustomer(cTEL, cID);
			if(result==SupermarketDao.SUCCESS) {
				jtxtPool.setText("���̵� : "+cID+"���� ��ȭ��ȣ�� �����Ǿ����ϴ�");
			}else {
				jtxtPool.setText("��ȿ�� ��ID�� �˻� �� ��ȣ������ �ϼ���");
			}
			
			//ȸ��Ż��.
		}else if (e.getSource()==jbtnDelete) {
			String cID = jtxtID.getText().trim();
				if(cID.equals("")) {
					jtxtPool.setText("������ ID �� �Է��ϼž� ������ �����մϴ�.");
					return;
				}
				
				int result = dao.deletecustomer(cID);
				if(result==SupermarketDao.SUCCESS) {
					jtxtPool.setText("ID : "+cID+"���� ID�� ���� �Ǿ����ϴ�.");
				}else {
					
					jtxtPool.setText("��ȿ�� ID�� �Է��� ���� ���ּ���.");
					
				}
				
			
			//���α׷� ����.
		}else if(e.getSource()==jbtnExit) { // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
			
		
	
	
	}//// actionPerformed

	public static void main(String[] args) {
		new SupermarketGUI("������");

	}
}
