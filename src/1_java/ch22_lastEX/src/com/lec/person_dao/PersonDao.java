package com.lec.person_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class PersonDao {
	// 생성자 함수 한번만 실행 할꺼임.

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

	// 1 번 insertPerson(PersonDto dto) 호출 !
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		// dto 값들을 DB에 넣기.
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
			result = pstmt.executeUpdate();//sql 전송.

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

	// 2번 selectJname(String jname)
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// jname 직업인 사람을 리스트 dtos 에 add 하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, S.* FROM (SELECT NAME||'('||NO||'번)' NAME , JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM " + 
				"    FROM PERSON P , JOB J WHERE P.JNO=J.JNO AND JNAME=? ORDER BY SUM DESC) S";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
//			jname = rs.getString("jname"); 안받아도 나올꺼임.
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

	// 3번 selectAll() 이렇게 수행댐.
	public ArrayList<PersonDto> selectAll() {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();

		String sql = "SELECT ROWNUM RANK, S.* FROM (SELECT NAME||'('||NO||'번)' NAME , JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
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
	//직업명들 가져오는것들.
	public Vector<String> jnamelist() {
		Vector<String> jnames = new Vector<String>(); //리턴값 선언.
		//직업들 리스트를  jname에 add 하기.
		jnames.add(""); //첫 선택지 빈스트링으로 해서 빈칸으로 나옴.
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
				
			}//close 트라이캐치절
		} //finally 트라이캐치절
		
		return jnames;
	}//main

}//class