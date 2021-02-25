package com.lec.supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class SupermarketDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static SupermarketDao INSTANCE;
	
	public static SupermarketDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new SupermarketDao();
		}
		return INSTANCE;
	}
	private SupermarketDao() {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} //try - catch
		
		
		
	}//Dao Class.forname 
	
	//0.�� ��޵�  combobox�� �߰�.
	public Vector<String> getLevelNames() {
		Vector<String> LevelNames = new Vector<String>();
		LevelNames.add(""); //ù ĭ ����.
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				LevelNames.add(rs.getString("LevelName"));
			}//while
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // conn = Driver�� try-catch ���� finally �� ����.
			 try {
				if(rs != null ) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				 
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		return LevelNames;
		
	}//Vector �� ��.
	
	//1.ID�˻�.
	public SupermarketDto selectCID (int cID) {
		SupermarketDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID,cTEL,cNAME,cPOINT, cAMOUNT, LEVELNAME, " + 
				"    (SELECT HIGH-cAMOUNT+1 FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) forlevelUp " + 
				"    FROM CUSTOMER C, CUS_LEVEL L WHERE C.LEVELNO=L.LEVELNO AND cID= ? ";
		
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String cTEL = rs.getString("cTEL");
				String cNAME = rs.getString("cNAME");
				int cPOINT = rs.getInt("cPOINT");
				int cAMOUNT = rs.getInt("cAMOUNT");
				String LevelName = rs.getString("LEVELNAME");
				int forlevelUp = rs.getInt("forlevelUp");
				dto = new SupermarketDto(cID, cTEL, cNAME, cPOINT, cAMOUNT, LevelName,forlevelUp);
			} //if
				
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
		}// try-catch-finally
		
		return dto;
	}//ID�˻���.
	
	//2. ��ȣ�˻�
	public ArrayList<SupermarketDto> selectCtel (String cTEL) {
		ArrayList<SupermarketDto> dtos = new ArrayList<SupermarketDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID,cTEL,cNAME,cPOINT, cAMOUNT, LEVELNAME, (SELECT HIGH-cAMOUNT+1 FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) forlevelUp " + 
				"    FROM CUSTOMER C, CUS_LEVEL L WHERE C.LEVELNO=L.LEVELNO AND cTEL LIKE '%'|| ? ";
		
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cTEL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cID = rs.getInt("cID");
				String cNAME = rs.getString("cNAME");
				int cPOINT = rs.getInt("cPOINT");
				int cAMOUNT = rs.getInt("cAMOUNT");
				String LevelName = rs.getString("LEVELNAME");
				int forlevelUp = rs.getInt("forlevelUp");
				dtos.add(new SupermarketDto(cID, cTEL, cNAME, cPOINT, cAMOUNT, LevelName, forlevelUp));
				
			}//while
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // conn = Driver�� try-catch ���� finally �� ����.
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}//// try-catch-finally
		
		return dtos;
		
	}//��ȣ�˻� ��.
	
	//3. �̸��˻�.
	public ArrayList<SupermarketDto> selectCName (String cNAME) {
		ArrayList<SupermarketDto> dtos = new ArrayList<SupermarketDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID,cTEL,cNAME,cPOINT, cAMOUNT, LEVELNAME, (SELECT HIGH-cAMOUNT+1 FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) forlevelUp " + 
				"    FROM CUSTOMER C, CUS_LEVEL L WHERE C.LEVELNO=L.LEVELNO AND cNAME = ? ";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cNAME);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				int cID = rs.getInt("cID");
				String cTEL = rs.getString("cTEL");
				int cPOINT = rs.getInt("cPOINT");
				int cAMOUNT = rs.getInt("cAMOUNT");
				String LevelName = rs.getString("LEVELNAME");
				int forlevelUp = rs.getInt("forlevelUp");
				dtos.add(new SupermarketDto(cID, cTEL, cNAME, cPOINT, cAMOUNT, LevelName, forlevelUp));
				
			}//while
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // conn = Driver�� try-catch ���� finally �� ����.
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}//// try-catch-finally

		return dtos;
		
		
	}//�̸��˻� ��.
	
	
	//4.����Ʈ�� ����
	public int BuyWithPoint (int cAMOUNT, int cID) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET cPOINT = cPOINT - ? WHERE cID= ? ";
		
		try {
			conn= DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cAMOUNT);
			pstmt.setInt(2, cID);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // conn = Driver�� try-catch ���� finally �� ����.
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}//// try-catch-finally
		
		return result;
	}//����Ʈ ���� ��.
	
	
	//5.��ǰ����
	public int Buy (int cAMOUNT, int cID) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET cPOINT = cPOINT + ?*0.05, cAMOUNT = cAMOUNT + ? ," + 
				"    LEVELNO = (SELECT L.LEVELNO �����ѷ��� " + 
				"    FROM CUSTOMER C, CUS_LEVEL L WHERE cAMOUNT+ ? BETWEEN LOW AND HIGH AND cID= ? )WHERE cID= ? ";
		
		try {
			conn= DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cAMOUNT);
			pstmt.setInt(2, cAMOUNT);
			pstmt.setInt(3, cAMOUNT);
			pstmt.setInt(4, cID);
			pstmt.setInt(5, cID);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // conn = Driver�� try-catch ���� finally �� ����.
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}//// try-catch-finally
		
		return result;
	}//��ǰ���� ��.
	
	//6.��޺� ���.
	public ArrayList<SupermarketDto> levelNames (String LevelName) {
		ArrayList<SupermarketDto> dtos = new ArrayList<SupermarketDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID,cTEL,cNAME,cPOINT, cAMOUNT, LEVELNAME, (SELECT HIGH-cAMOUNT+1 FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) forlevelUp " + 
				"    FROM CUSTOMER C, CUS_LEVEL L WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME= ? ORDER BY cAMOUNT DESC";
		
		try {
			conn=DriverManager.getConnection(url,"scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, LevelName);
			rs =pstmt.executeQuery();
			while(rs.next()) {
				int cID = rs.getInt("cID");
				String cTEL = rs.getString("cTEL");
				String cNAME= rs.getString("cNAME");
				int cPOINT = rs.getInt("cPOINT");
				int cAMOUNT = rs.getInt("cAMOUNT");
				int forlevelUp = rs.getInt("forlevelUp");
				dtos.add(new SupermarketDto(cID, cTEL, cNAME, cPOINT, cAMOUNT, LevelName, forlevelUp));	
			}//while
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // conn = Driver�� try-catch ���� finally �� ����.
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}//// try-catch-finally
		
		return dtos;
		
		
	}//��޺� ��� ��.
	
	//��ü ���
	public ArrayList<SupermarketDto> selectCustomerAll() {
		ArrayList<SupermarketDto> dtos = new ArrayList<SupermarketDto>();
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs = null;
		String sql = "SELECT cID,cTEL,cNAME,cPOINT, cAMOUNT, LEVELNAME, (SELECT HIGH-cAMOUNT+1 FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) forlevelUp " + 
				"    FROM CUSTOMER C, CUS_LEVEL L WHERE C.LEVELNO=L.LEVELNO ";
		
		try {
			conn=DriverManager.getConnection(url,"scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int cID = rs.getInt("cID");
				String cTEL = rs.getString("cTEL");
				String cNAME= rs.getString("cNAME");
				int cPOINT = rs.getInt("cPOINT");
				int cAMOUNT = rs.getInt("cAMOUNT");
				String LevelName = rs.getString("LevelName");
				int forlevelUp = rs.getInt("forlevelUp");
				dtos.add(new SupermarketDto(cID, cTEL, cNAME, cPOINT, cAMOUNT, LevelName, forlevelUp));	
			}//while
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // conn = Driver�� try-catch ���� finally �� ����.
			try {
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}//// try-catch-finally
	
		
		return dtos;
		
	}//��ü��� ��.
	
	//ȸ������.
	public int insertCustomer (String cTEL, String cNAME) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (cID,cTEL,cNAME) VALUES (CUSTOMER_SEQ.NEXTVAL, ? , ? )";
		
		try {
			conn= DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cTEL);
			pstmt.setString(2, cNAME);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // conn = Driver�� try-catch ���� finally �� ����.
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}//// try-catch-finally
		
		return result;
	}//ȸ������ ��.
	
	//��ȣ����
	public int updatecustomer (String cTEL, int cID) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET cTEL = ? WHERE cID = ? ";
		
		try {
			conn= DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cTEL);
			pstmt.setInt(2, cID);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // conn = Driver�� try-catch ���� finally �� ����.
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}//// try-catch-finally
		
		return result;
	}//��ȣ���� ��.
	
	//Ż��.
	public int deletecustomer (String cID) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE cID = ? ";
		
		try {
			conn= DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cID);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // conn = Driver�� try-catch ���� finally �� ����.
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}//// try-catch-finally
		
		return result;
	
	}
	
}
