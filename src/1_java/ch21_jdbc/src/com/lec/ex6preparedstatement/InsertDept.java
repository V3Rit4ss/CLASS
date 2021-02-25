package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("추가 할 부서번호는?");
		int deptno = sc.nextInt();
		System.out.print("추가 할 부서이름은?");
		String dname = sc.next();
		System.out.print("추가 할 부서위치는?");
		sc.nextLine();
		String loc = sc.nextLine();
		//DB접속 하여 insert 실행.
		String sql = "INSERT INTO DEPT VALUES ( ? , ? , ? )"; // ( ? , ? , ? )=> 가능 , ( ? ,' ? ', ? ) => 불가능.
		
		Connection conn = null;
		PreparedStatement pstmt = null;   
		
		try {
			Class.forName(driver); //1
			conn = DriverManager.getConnection(url, "scott" , "tiger");
			pstmt = conn.prepareStatement(sql); //위
//			stmt = conn.createStatement(); //아래 : 위와 아래의 차이점.
			pstmt.setInt(1, deptno); // deptno 변수가 스트링이라면. setString.  ,  int 면 setInt.
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
//			int result = stmt.executeUpdate(sql);
			int result = pstmt.executeUpdate();
			System.out.println(result >0? deptno+"번 입력 성공" : "입력 실패");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(deptno+"번 입력실패");  // 입력실패로 가는 값이 null 이라서 일로 떨어질꺼임.
		} finally {
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
		
		
			}
		}
	}
}