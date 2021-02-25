package com.lec.studentGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.lec.Student.StudentDao;

public class StudentSwingDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static StudentSwingDao INSTANCE;
	
	public static StudentSwingDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new StudentSwingDao();
		}
		return INSTANCE;
	}
	
	private StudentSwingDao() {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	//0. 전공이름들 combobox에 추가.
	public Vector<String> getMNamelist() {
		Vector<String> mNames = new Vector<String>();
		mNames.add("");
		String sql = "SELECT mNAME FROM MAJOR";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mNames.add(rs.getString("mName"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		
		return mNames;
		
	}
	
	//1. 학생입력.
	public int insertStudentSwing(String sName, String mName, int score) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT  (sNO, sNAME, mNO, SCORE) VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')), ? , (SELECT mNO FROM MAJOR WHERE mNAME= ? ), ? )";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			pstmt.setString(2, mName);
			pstmt.setInt(3, score);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return result;
		
	}
	
	//2. 학번검색. //중복이 없어야하기에 어레이리스트 x
	public StudentSwingDto sNogetStudent(String sNo) {
		StudentSwingDto dto = null;
		Connection         conn  = null;
		PreparedStatement  pstmt = null;
		ResultSet          rs    = null;
		String sql = "SELECT sNO, sNAME, mNAME , SCORE FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND sNO = ? ";
		
		try {
			conn=DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dto = new StudentSwingDto(sNo, sName, mName, score);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
		
		
		
	}
	
	//3. 이름검색.  // 중복이 있을수있으니 어레이리스트.
	public ArrayList<StudentSwingDto> selectSname (String sName) {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT sNO, sNAME , mNAME, SCORE FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND sNAME = ? ";
		
		try {
			conn = DriverManager.getConnection(url, "scott" , "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			rs   = pstmt.executeQuery(); 
			
			while(rs.next()) {
				String sNo = rs.getString("sNo");
				//String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(sNo, sName, mName, score));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
		
		
	}
	
	//4.전공검색.
	public ArrayList<StudentSwingDto> selectMname (String mName) {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection         conn  = null;
		PreparedStatement  pstmt = null;
		ResultSet          rs    = null;
		String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' sNAME, mNAME, SCORE FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND  mNAME = ? )";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			rs   = pstmt.executeQuery(); 
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				mName = rs.getString("mName"); // 파라미터로 입력된 mName이 빅데이터의 경우 여기서의 mName은 빅데이터(1)
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(rank, sName, mName, score));
				
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return dtos;
	}
	
	//5.학생수정.
	public int updateStudentSwing(String sName, String mName, int score, String sNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET sNAME= ? , mNO=(SELECT mNO FROM MAJOR WHERE mNAME= ? ), SCORE = ?  WHERE sNO= ? ";
		
		try {
			conn = DriverManager.getConnection(url, "scott" , "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			pstmt.setString(2, mName);
			pstmt.setInt(3, score);
			pstmt.setString(4, sNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return result;
		
	}
	
	//6.학생출력(제적자 제외).
	public ArrayList<StudentSwingDto> StudentAll() {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')'sNAME,mNAME||'('||mNO||')'mNAME, SCORE " + 
				"   FROM (SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND EXPEL=0 ORDER BY SCORE DESC)";
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(sql); 
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(rank, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return dtos;
	}
	
	//7.제적처리
	public int StudentExpel(String sNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET EXPEL=1 WHERE sNO= ? ";
		
		try {
			conn = DriverManager.getConnection(url, "scott" ,"tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		return result;
	}
	
	//8.제적자 출력
	public ArrayList<StudentSwingDto> ExpelStudent(){
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')'sNAME, mNAME||'('||mNO||')'mNAME, SCORE " + 
				"    FROM (SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND EXPEL=1 ORDER BY SCORE DESC)";
		try {
			conn =DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(rank, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn  !=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return dtos;
		
	}
	
	
	
	
}
