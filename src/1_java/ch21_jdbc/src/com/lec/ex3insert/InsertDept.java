package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 부서번호는?");
		int deptno = sc.nextInt();
		System.out.print("입력 할 부서이름은?");
		String dname = sc.next();
		System.out.print("입력 할 부서의 위치는?");
		sc.nextLine(); // \n이 있는 버퍼 지우기.
		String loc = sc.nextLine();

		Connection conn = null;
		Statement stmt = null;

//		String sql = "INSERT INTO DEPT VALUES ("+deptno+",'"+dname+"','"+loc+"')";
		String sql = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno, dname, loc);

		try {
			Class.forName(driver); // 1.
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
			stmt = conn.createStatement(); // 3
			int result = stmt.executeUpdate(sql); //4+5
			System.out.println(result > 0 ? "부서입력 성공." : "부서입력 실패"); // 3항 연산자. //6
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { //7
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
