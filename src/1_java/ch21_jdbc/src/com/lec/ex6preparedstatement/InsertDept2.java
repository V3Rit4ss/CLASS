package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		String insertSql = "INSERT INTO DEPT VALUES ( ? , ? , ? )"; // ( ? , ? , ? )=> 가능 , ( ? ,' ? ', ? ) => 불가능.
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO= ? ";

		System.out.print("추가 할 부서번호는?");
		int deptno = sc.nextInt();
		// 해당 부서번호가 있는지 확인후 부서추가
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			if (!rs.next()) { //rs.next 가 아닐때 추가가능.
				 System.out.print("추가 할 부서이름은?"); 
				 String dname = sc.next();
				  System.out.print("추가 할 부서위치는?"); 
				  sc.nextLine(); 
				  String loc = sc.nextLine();
				  
				  rs.close(); //pstmt가 rs로 들어갔기에 둘다 close.
				  pstmt.close(); //아래 pstmt을 새로 만들기 위해서 닫음.
				  
				  pstmt = conn.prepareStatement(insertSql);
				  pstmt.setInt(1, deptno);
				  pstmt.setString(2, dname);
				  pstmt.setString(3, loc);
				  
				  int result = pstmt.executeUpdate();
				  System.out.println(result>0? deptno+"번 부서 추가 성공" : "부서 추가 실패");
			}else {
				System.out.println("중복된 부서번호는 추가가 불가합니다.");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(deptno + "번 추가 실패"); //위에있는 삼항연산자의 실패 부분이 일로옴.
		} finally {
			
			try {
				
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		} catch (Exception e) {
			
			
			
		}
	 }
   }
}
		