package com.lec.studentGUI;

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

public class SwingStudentMug extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private Vector<String> mNames;
	private JComboBox<String> comMname;
	private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch;
	private JButton btnInput, btnUpdate;
	private JButton btnStudentOut, btnExpelOut, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private String dirver;
	private String url;
	StudentSwingDao dao = StudentSwingDao.getInstance();

	public SwingStudentMug(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane(); // 화면을 구현함.
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		mNames = dao.getMNamelist();
		comMname = new JComboBox<String>(mNames);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("학번 검색");
		btnSNameSearch = new JButton("이름 검색");
		btnMNameSearch = new JButton("전공 검색");
		btnInput = new JButton("학생 입력");
		btnUpdate = new JButton("학생 정보 수정");
		btnStudentOut = new JButton("학생 출력");
		btnExpel = new JButton("제적 처리");
		btnExpelOut = new JButton("제적자 출력");
		btnExit = new JButton("종 료");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(600, 400));
		setLocation(200, 150);
		setVisible(true);
		// 버튼 활성화
		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnSNoSearch) {   // 학번 검색
				String sNo = txtSNo.getText().trim();
				if(sNo.equals("")) {
					txtSName.setText("");
					comMname.setSelectedItem("");
					comMname.setSelectedIndex(0);
					txtScore.setText("");
					txtPool.setText("학번을 입력 후  검색을 해주세요");
					return;
				}// if - 학번을 입력하지 않은 경우
				StudentSwingDto dto = dao.sNogetStudent(sNo);
				if(dto!=null) { // 해당 학번이 DB에 검색된 경우
					txtSName.setText(dto.getsName());
					comMname.setSelectedItem(dto.getmName());
					//txtScore.setText(""+dto.getScore()); // score값을 스트링으로 바꿔서 txtField에 넣음
					txtScore.setText(String.valueOf(dto.getScore()));
					txtPool.setText(sNo+" 검색 완료");
				}else { // 해당 학번이 DB에 없는 경우
					txtSName.setText("");
					comMname.setSelectedItem("");
					txtScore.setText("");
					txtPool.setText(sNo+"은 유효하지 않는 학번입니다");
				}//if
			}else if(e.getSource()==btnSNameSearch) { // 이름 검색
				String sName = txtSName.getText().trim();
				if(sName.length()==0) {
					txtSNo.setText("");
					comMname.setSelectedIndex(0);
					txtScore.setText("");
					txtPool.setText("이름을 입력 한 후에 검색해주세요");
					return;
				}// if - 이름을 입력하지 않은 경우
				ArrayList<StudentSwingDto> students = dao.selectSname(sName);
				if(students.size()>1) {
					txtPool.setText("\t학번\t이름\t학과명\t점수\n");
					txtPool.append("\t──────────────────────────\n");
					for(StudentSwingDto student : students) {
						txtPool.append("\t"+student.toString()+"\n");
						txtSNo.setText(student.getsNo());
						comMname.setSelectedItem(student.getmName());
						//txtScore.setText(""+student.getScore());
						txtScore.setText(String.valueOf(student.getScore()));
					}//for
				}else if(students.size()==1){
					txtSNo.setText(students.get(0).getsNo());
					comMname.setSelectedItem(students.get(0).getmName());
					//txtScore.setText(""+students.get(0).getScore());
					txtScore.setText(String.valueOf(students.get(0).getScore()));
				}else {
					txtSNo.setText("");
					comMname.setSelectedItem("");
					txtScore.setText("");
					txtPool.setText("해당 이름의 학생이 없습니다");
				}// if
			}else if(e.getSource()==btnMNameSearch) {//전공검색
				txtSNo.setText("");
				txtSName.setText("");
				txtScore.setText("");
				String mName = comMname.getSelectedItem().toString();
				if(mName.equals("")) {
					txtPool.setText("전공은 선택하고 검색해야지");
					return;
				}
				ArrayList<StudentSwingDto> students = dao.selectMname(mName);
				if(students.size()!=0) {
					txtPool.setText("\t학번\t이름\t학과명\t점수\n");
					txtPool.append("\t──────────────────────────\n");
					for(StudentSwingDto student : students) {
						txtPool.append("\t"+student.toString()+"\n");
					}//for
				}else {
					txtPool.setText("해당 학과의 학생이 없습니다");
				}// if
			}else if(e.getSource()==btnInput) {//학생입력
				String sName = txtSName.getText().trim();
				String mName = comMname.getSelectedItem().toString();
				if(sName.equals("") || mName.equals("")) {
					txtPool.setText("학생입력시 학번, 이름, 전공을 입력해야해");
					return;
				}
				txtPool.setText("");
				int score = 0;
				try {
					score = Integer.parseInt(txtScore.getText().trim());
					if(score<0 || score>100) {
						txtPool.append("유효한 점수가 아니면 0점 처리\n");
						score = 0;
					}
				}catch (NumberFormatException e1) {
					txtPool.append("점수를 입력 안 하거나 문자로 입력하면 0점 처리\n");
				}// try-catch (score 입력)
//				StudentSwingDto newStudent = new StudentSwingDto(0, sName, mName, score);
//				int result = dao.insertStudent(newStudent);
				int result = dao.insertStudentSwing(sName, mName, score);
				if(result == StudentSwingDao.SUCCESS) {
					txtPool.append(sName+" 학생 입력 성공");
					txtSNo.setText("");
					txtSName.setText("");
					comMname.setSelectedIndex(0);
					txtScore.setText("");
				}//if
			}else if(e.getSource()==btnUpdate) { // 학생수정
				String sNo = txtSNo.getText().trim();
				String sName = txtSName.getText().trim();
				String mName = comMname.getSelectedItem().toString();
				if(sNo.equals("") || sName.equals("") || mName.equals("")) {
					txtPool.setText("학생수정시 학번, 이름, 전공을 입력해야해");
					return;
				}
				txtPool.setText("");
				int score = 0;
				try {
					score = Integer.parseInt(txtScore.getText().trim());
					if(score<0 || score>100) {
						txtPool.append("유효한 점수가 아니면 0점 처리");
						score = 0;
					}
				}catch (NumberFormatException e1) {
					txtPool.append("점수를 입력 안 하거나 문자로 입력하면 0점 처리");
				}// try-catch (score 입력)
				StudentSwingDto student = new StudentSwingDto(sNo, sName, mName, score);
				int result = dao.updateStudentSwing(sName, mName, score, sNo);
//				result = dao.updateStudent(sNo, sName, mName, score);
				if(result == StudentSwingDao.SUCCESS) {
					txtPool.append(sName+" 학생 입력 수정");
				}//if
			}else if(e.getSource()==btnStudentOut) { //학생출력(제적자제외)
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
				ArrayList<StudentSwingDto> students = dao.StudentAll();
				if(students.size()!=0) {
					txtPool.setText("\t학번\t이름\t학과명\t점수\n");
					txtPool.append("\t──────────────────────────\n");
					for(StudentSwingDto student : students) {
						txtPool.append("\t"+student.toString()+"\n");
					}//for
				}else {
					txtPool.setText("학생이 없습니다");
				}// if
			}else if(e.getSource()==btnExpelOut) { // 제적자만 출력
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
				ArrayList<StudentSwingDto> students = dao.ExpelStudent();
				if(students.size()!=0) {
					txtPool.setText("\t학번\t이름\t학과명\t점수\n");
					txtPool.append("\t──────────────────────────\n");
					for(StudentSwingDto student : students) {
						txtPool.append("\t"+student.toString()+"\n");
					}//for
				}else {
					txtPool.setText("제적자가 없습니다");
				}// if
			}else if(e.getSource()==btnExpel) { // 제적처리
				String sNo = txtSNo.getText().trim();
				if(sNo.length()==0) {
					txtPool.setText("학번은 입력하고 제적처리해야지");
					return;
				}
				int result = dao.StudentExpel(sNo);
				if(result == StudentSwingDao.SUCCESS) {
					txtPool.setText(sNo+" 학생 제적 처리 완료");
				}//if
			}else if(e.getSource()==btnExit) { // 종료버튼
				setVisible(false);
				dispose();
				System.exit(0);
			}// if - e.getSource()
		}// actionPerformed
	public static void main(String[] args) {
		new SwingStudentMug("학사관리");
		
	}//main
}//class
