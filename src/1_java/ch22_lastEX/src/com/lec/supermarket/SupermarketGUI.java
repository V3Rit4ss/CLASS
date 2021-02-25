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
		jbtnIDsearch = new JButton("아이디 검색");
		jbtnTelSearch = new JButton("전화번호 뒷자리(또는 전체) 검색");
		jbtnNameSearch = new JButton("고객 이름 검색");
		jbtnBuyWhitPoint = new JButton("포인트로만 구매");
		jpup.add(new JLabel(" 아 이 디 ", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtID);
		jpup.add(jbtnIDsearch);
		jpup.add(new JLabel("고 객 전 화", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtTel);
		jpup.add(jbtnTelSearch);
		jpup.add(new JLabel("고 객 이 름", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtName);
		jpup.add(jbtnNameSearch);
		jpup.add(new JLabel("포  인  트", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtPoint);
		jpup.add(jbtnBuyWhitPoint);
		jpup.add(new JLabel("구 매 금 액", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtAmount);
		jpup.add(new JLabel(""));// 빈 라벨 추가하는 부분
		jpup.add(new JLabel("고 객 등 급", (int) CENTER_ALIGNMENT));
		jpup.add(jcomLevel);
		jbtnBuy = new JButton("물품 구매");
		jbtnLevelOutput = new JButton("등급별출력");
		jbtnAllOutput = new JButton("전체출력");
		jbtnInsert = new JButton("회원가입");
		jbtnTelUpdate = new JButton("번호수정");
		jbtnDelete = new JButton("회원탈퇴");
		jbtnExit = new JButton("나가기");
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
		jtxtPool.setText("\t★ ★ ★ 고객검색 후 구매하세요 ★ ★ ★");

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
		
		//아이디검색.
		if(e.getSource()== jbtnIDsearch) { 
			
			int cID  = 0;
			try {
				
				
				cID = Integer.parseInt(jtxtID.getText().trim());
				
			} catch (NumberFormatException e1) {
				
				jtxtPool.setText("ID를 입력후 검색 해주세요.");
			
				return;
			}
				
			SupermarketDto customer = dao.selectCID(cID);
			if(customer != null) {
				jtxtPool.setText("ID\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				jtxtPool.append("──────────────────────────────────\n");
				jtxtPool.append(customer.toString()+"\n");
				jtxtTel.setText(customer.getcTEL());
				jtxtName.setText(customer.getcNAME());
				jtxtPoint.setText(String.valueOf(customer.getcPOINT()));
				jtxtAmount.setText("");
				jcomLevel.setSelectedItem(customer.getLevelName());
			}else {
				
				jtxtPool.setText("검색되지 않은 ID입니다");
			}  
				
		} else if(e.getSource()==jbtnTelSearch) {// ID - if절. 끝. TEL검색 시작.
			String cTEL = jtxtTel.getText().trim();
			if(cTEL.length() < 4) {
				jtxtPool.setText("최소한 전화번호 뒷번호 4자리를 입력해주시고 검색 해주세요.");
				return;
			} //if = 최소한의 번호를 입력 했는지 여부.
			
			ArrayList<SupermarketDto> customers = dao.selectCtel(cTEL);
			if(customers.size() >= 1 ) {
				jtxtPool.setText("ID\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				jtxtPool.append("────────────────────────────────────────\n");
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
				jtxtPool.setText("해당 전화번호의 고객이 검색되지 않습니다, 먼저 회원가입을 해주세요.");
				jtxtID.setText("");
				jtxtName.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
				
			}//if - catch dao.selectCtel(cTEL) 
			
			
		}else if(e.getSource()==jbtnNameSearch) { //고객이름 검색.
			String cNAME = jtxtName.getText().trim();
			if(cNAME.length() == 0) {
				
				jtxtPool.setText(" 이름을 입력하시고 검색하세요");
				return;
			}// if - 이름을 입력하지 않은경우
			ArrayList<SupermarketDto> customers = dao.selectCName(cNAME);
			if(customers.size()>=1) {
				jtxtPool.setText("ID\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				jtxtPool.append("────────────────────────────────────────\n");
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
				jtxtPool.setText(" 고객이름이 검색되지 않습니다. 회원가입을 해주세요");
				jtxtID.setText("");
				jtxtName.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
			}//if - catch dao.selectCName(cNAME)
			
			//포인트로만 구매.
		}else if(e.getSource()==jbtnBuyWhitPoint) {
			int cID = 0, cAMOUNT = 0, cPOINT = 0;
			try {
				cID = Integer.parseInt(jtxtID.getText().trim());
				cAMOUNT = Integer.parseInt(jtxtAmount.getText().trim());
				cPOINT = Integer.parseInt(jtxtPoint.getText().trim());
				if(cPOINT<cAMOUNT) {
					jtxtPool.setText("포인트가 부족하여 포인트로 구매 불가능합니다");
					return;
				}
			}catch (NumberFormatException e1) {
				jtxtPool.setText("유효한 고객ID와 구매금액을 입력하시고, 지불 가능한 포인트로 구매하세요");
				return;
			}
			int result = dao.BuyWithPoint(cAMOUNT, cID);
			if (result==SupermarketDao.SUCCESS) {
				jtxtPool.setText("포인트로 구매 성공");
				jtxtPoint.setText(String.valueOf(cPOINT-cAMOUNT));
				jtxtAmount.setText("");
			}else {
				jtxtPool.setText("고객 아이디가 유효하지 않습니다");
			}// 포인트 구매 끝.
			
			//물품구매.
		}else if(e.getSource()==jbtnBuy) {
			int cID = 0, cAMOUNT = 0, cPOINT = 0;
			
			try {
				cID = Integer.parseInt(jtxtID.getText().trim());
				cAMOUNT = Integer.parseInt(jtxtAmount.getText().trim());
				cPOINT = Integer.parseInt(jtxtPoint.getText().trim());
			} catch (NumberFormatException e2) {
				jtxtPool.setText("유효한 고객 아이디와 구매하실 금액을 입력하시고 구매를 부탁드립니다.");
				return;
			}
			
			int result = dao.Buy(cAMOUNT, cID);
			if (result==SupermarketDao.SUCCESS) {
				jtxtPool.setText("물품구매 및 등급 조정 성공");
				jtxtPoint.setText(String.valueOf((int)(cPOINT+cAMOUNT*0.05)));
				jtxtAmount.setText("");
				
			}else {
				jtxtPool.setText("고객 아이디가 유효하지 않습니다");
			}
			
			
			// 등급별출력
		}else if(e.getSource()==jbtnLevelOutput) {
			
			jtxtID.setText("");
			jtxtTel.setText("");
			jtxtName.setText("");
			jtxtPoint.setText("");
			String levelName = jcomLevel.getSelectedItem().toString();
			if(levelName.equals("")) {
				jtxtPool.setText("원하는 등급을 선택하시고 검색하세요");
				return;
			}// if - 폰4자리 이상 입력했는지
			ArrayList<SupermarketDto> customers = dao.levelNames(levelName);
			if(customers.size() != 0 ) {
				jtxtPool.setText("ID\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				jtxtPool.append("────────────────────────────────────────────────────────\n");
				for(SupermarketDto customer : customers) {
					jtxtPool.append(customer.toString()+"\n");
				}//for
				jtxtPool.append("총 "+customers.size()+"명");
			}else {
				jtxtPool.setText("해당 레벨의 고객이 검색되지 않습니다. 회원가입 해 주세요");
				
			}//등급별 출력 끝.
			
			
			
			//회원 전체출력.
		}else if(e.getSource()==jbtnAllOutput) {
			
			jtxtID.setText("");
			jtxtTel.setText("");
			jtxtName.setText("");
			jtxtPoint.setText("");
			jcomLevel.setSelectedIndex(0);
			ArrayList<SupermarketDto> customers = dao.selectCustomerAll();
			if(customers.size()!=0) {
				jtxtPool.setText("ID\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				jtxtPool.append("────────────────────────────────────────────────────────\n");
				for(SupermarketDto customer : customers) {
					jtxtPool.append(customer.toString()+"\n");
				}//for
				jtxtPool.append("총 "+customers.size()+"명");
			}else {
				jtxtPool.setText("가입한 고객님이 없습니다.");
				
			}
			
			
			//회원가입.
		}else if(e.getSource()==jbtnInsert) {
			jtxtID.setText("");
			jtxtAmount.setText("");	
			String cNAME = jtxtName.getText().trim();
			String cTEL = jtxtTel.getText().trim();
			if(cNAME.equals("")|| cTEL.equals("")) {
				jtxtPool.setText("회원 가입시, 성명과 전화번호를 필히 입력해주시길 바랍니다.");
				return;
			}
			jtxtPool.setText("");
			
			int result = dao.insertCustomer(cTEL, cNAME);
			if(result == SupermarketDao.SUCCESS) {
				jtxtPool.append(cNAME+"고객님 회원가입을 해주셔서 감사합니다 ! 포인트 1000점을 회원가입 선물로 드립니다.");
				jtxtPoint.setText("1000");
				jcomLevel.setSelectedIndex(0);
			}
			
			//전화번호 수정.
		}else if(e.getSource()==jbtnTelUpdate) {
			
			int cID= 0; String cTEL;
			try {
				cID = Integer.parseInt(jtxtID.getText().trim());
				cTEL = jtxtTel.getText().trim();
				if(cTEL.equals("")) {
					jtxtPool.setText("변경할 전화번호를 입력하셔야 번호수정이 가능합니다.");
					return;
				}
			}catch (NumberFormatException e1) {
				jtxtPool.setText("유효한 고객ID를 검색 후 변호변경을 하세요");
				return;
			}
			int result = dao.updatecustomer(cTEL, cID);
			if(result==SupermarketDao.SUCCESS) {
				jtxtPool.setText("아이디 : "+cID+"님의 전화번호가 수정되었습니다");
			}else {
				jtxtPool.setText("유효한 고객ID를 검색 후 변호변경을 하세요");
			}
			
			//회원탈퇴.
		}else if (e.getSource()==jbtnDelete) {
			String cID = jtxtID.getText().trim();
				if(cID.equals("")) {
					jtxtPool.setText("삭제할 ID 를 입력하셔야 삭제가 가능합니다.");
					return;
				}
				
				int result = dao.deletecustomer(cID);
				if(result==SupermarketDao.SUCCESS) {
					jtxtPool.setText("ID : "+cID+"님의 ID가 삭제 되었습니다.");
				}else {
					
					jtxtPool.setText("유효한 ID를 입력후 삭제 해주세요.");
					
				}
				
			
			//프로그램 종료.
		}else if(e.getSource()==jbtnExit) { // 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
			
		
	
	
	}//// actionPerformed

	public static void main(String[] args) {
		new SupermarketGUI("고객관리");

	}
}
