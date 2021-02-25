package com.lec.person_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class PersonDao {
	// ������ �Լ� �ѹ��� ���� �Ҳ���.

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static PersonDao INSTANCE;

	public static PersonDao getINTANCE() {
		if (INSTANCE == null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}

	private PersonDao() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1 �� insertPerson(PersonDto dto) ȣ�� !
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		// dto ������ DB�� �ֱ�.
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ? ,(SELECT JNO FROM JOB WHERE JNAME= ? ), ? , ? , ? )";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();//sql ����.

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();

			} catch (Exception e) {

			}
		}
		return result;
	}

	// 2�� selectJname(String jname)
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// jname ������ ����� ����Ʈ dtos �� add �ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, S.* FROM (SELECT NAME||'('||NO||'��)' NAME , JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM " + 
				"    FROM PERSON P , JOB J WHERE P.JNO=J.JNO AND JNAME=? ORDER BY SUM DESC) S";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
//			jname = rs.getString("jname"); �ȹ޾Ƶ� ���ò���.
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank, name, jname, kor, eng, mat, sum));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {

			}

		}

		return dtos;
	}

	// 3�� selectAll() �̷��� �����.
	public ArrayList<PersonDto> selectAll() {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();

		String sql = "SELECT ROWNUM RANK, S.* FROM (SELECT NAME||'('||NO||'��)' NAME , JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
				+ "    FROM PERSON P , JOB J WHERE P.JNO=J.JNO ORDER BY SUM DESC) S";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank, name, jname, kor, eng, mat, sum));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e) {

			}

		}
		return dtos;

	}
	//������� �������°͵�.
	public Vector<String> jnamelist() {
		Vector<String> jnames = new Vector<String>(); //���ϰ� ����.
		//������ ����Ʈ��  jname�� add �ϱ�.
		jnames.add(""); //ù ������ ��Ʈ������ �ؼ� ��ĭ���� ����.
		String sql = ("SELECT JNAME FROM JOB");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				
			}//close Ʈ����ĳġ��
		} //finally Ʈ����ĳġ��
		
		return jnames;
	}//main

}//class