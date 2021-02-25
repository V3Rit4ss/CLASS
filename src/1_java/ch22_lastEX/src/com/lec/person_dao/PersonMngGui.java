package com.lec.person_dao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonMngGui extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> jnames;
	private JComboBox<String> comJob;
	private JButton btnInput,btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane; 
	private PersonDao dao = PersonDao.getINTANCE(); //위에서 선언해도 되고 아래에서 선언해도 되고.
	private ArrayList<PersonDto> person; 
	
	public PersonMngGui (String title) { //매개변수가 들어있는 생성자 함수.
		super(title); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); //윈도우x 버튼 활성화.
		contenPane = getContentPane(); //전체화면
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(5 , 2));
		//jpup = new JPanel();
		//jpup.setLayot(new GridLayout());  위나 아래나 상관은없지만 ...
		jpbtn  = new JPanel(new FlowLayout());
		txtName = new JTextField(20);
		jnames = dao.jnamelist();
		comJob = new JComboBox<String>(jnames);
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		ImageIcon icon1 = new ImageIcon("icon/write.gif");
		btnInput = new JButton("입력",icon1);
		ImageIcon icon2 = new ImageIcon("icon/hot.gif");
		btnSearch = new JButton("작업 조회", icon2);
		btnOutput = new JButton("전체 출력");
		btnExit = new JButton("종료");
		txtPool = new JTextArea(10, 60);
		scrollPane = new JScrollPane(txtPool);

		jpup.add(new JLabel("이름",(int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("직업", (int)CENTER_ALIGNMENT));
		jpup.add(comJob);
		jpup.add(new JLabel("국어", (int)CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("영어", (int)CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("수학", (int)CENTER_ALIGNMENT));
		jpup.add(txtMat);
		jpbtn.add(btnInput);
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(700, 450));
		setLocation(200, 150);
		setVisible(true);
		
		//액션리스너 임플리먼트 해야함.
		
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInput) { //이름,직업명,국영수 받아와서 dao.insert 호출
			String name = txtName.getText().trim(); //스페이스바 삭제.
			String jname = comJob.getSelectedItem().toString().trim();
			String korStr = txtKor.getText().trim();
			String engStr = txtEng.getText().trim();
			String matStr = txtMat.getText().trim();
			if(name.equals("")||jname.equals("")||korStr.equals("")||engStr.equals("")||matStr.equals("")) {
				txtPool.setText("이름, 직업,  국, 영, 수  모두 입력 하셔야 입력 가능.");
				
				return;
			
			}
			
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			PersonDto newPerson = new PersonDto(name, jname, kor, eng, mat); //인서트.
			int result = dao.insertPerson(newPerson);
			if(result==PersonDao.SUCCESS) {
				txtPool.setText(name+"님 입력 성공.");
				txtName.setText("");
				comJob.setSelectedIndex(0); //콤보박스 0번째 인위적으로 선택하게 함.
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
			}//if
		}else if(e.getSource()==btnSearch) { //직업명으로 dao.selectJname 호출.
			String jname = comJob.getSelectedItem().toString().trim();
			if(jname.equals("")) {
				txtPool.setText("직업을 선택 후 직업조회 하세요.");
				
				return;
				
			}
			person = dao.selectJname(jname);
			txtPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
			if(person.isEmpty()) {
				txtPool.setText(txtPool.getText()+"해당 직업군의 인원이 없습니다.");
			}else {
				for(PersonDto p : person) {
					txtPool.append(p.toString()+"\n");
				}
			}
		}else if(e.getSource()==btnOutput) { //dao.selectAll 호출.
			person = dao.selectAll();
			txtPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
			if(person.isEmpty()) {
				txtPool.setText(txtPool.getText()+"해당 직업군의 인원이 없습니다.");
			}else {
				for(PersonDto p : person) {
					txtPool.append(p.toString()+"\n");
				}
			}
		}else if(e.getSource()==btnExit) { //
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new PersonMngGui("연애인 성적 관리");
	}
	
}
