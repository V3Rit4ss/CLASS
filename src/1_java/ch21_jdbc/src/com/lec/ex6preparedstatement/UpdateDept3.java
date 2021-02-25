package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO= ?";
		System.out.print("수정하고자 하는 부서 번호는?");
		int deptno = sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(rs.next()) { //수정 진행.
				System.out.print("수정할 부서이름은?");
				String dname = sc.next();
				System.out.print("수정할 부서위치는?");
				String loc = sc.next();
				
				rs.close();
				pstmt.close();
				String sql2 = "UPDATE DEPT SET DNAME= ? , LOC = ? WHERE DEPTNO= ?";  //? 의 위치가 어디인지 쉽게 보기위해 위에서 아래로 가져옴.
				pstmt = conn.prepareStatement(sql2);
				
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0? "수정 성공" : "수정 실패");
				
			}else {
				System.out.println("존재하지 않는 부서입니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("수정 실패");
		} finally {
			try {
				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
				
		  }
	   }
	}
}
