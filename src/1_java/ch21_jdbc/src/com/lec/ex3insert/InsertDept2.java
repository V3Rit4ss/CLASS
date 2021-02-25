package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 부서번호는?");
		int deptno = sc.nextInt();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver);// 1
			conn = DriverManager.getConnection(url, "scott", "tiger");// 2
			stmt = conn.createStatement();// 3
			rs = stmt.executeQuery(selectSql);// 4+5
			if (rs.next()) {
				System.out.println("중복된 부서 번호는 입력 불가합니다.");
			} else {
				System.out.print("입력할 부서이름은?");
				String dname = sc.next();
				System.out.print("입력할 부서위치는?");
				sc.nextLine(); // 버퍼 지우기.
				String loc = sc.nextLine();
				String insertSql = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno, dname, loc);

				int result = stmt.executeUpdate(insertSql);
				System.out.println(result > 0 ? "입력성공" : "입력실패");
				/*
				 * if(result >0) { System.out.println("입력성공."); }else {
				 * System.out.println("입력 실패"); }
				 */
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // 7
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
				if (rs != null) rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}//
}//class
