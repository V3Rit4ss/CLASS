package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 부서번호는?");
		String deptno = sc.next(); // 스트링 50 으로 들어감. 상관은 없지만 혹시나 하는맘에 int는 int 대로 하는게 좋음.
		
		//입력한 해당 부서번호가 있는지 없는지 체크.
		String selectQuery = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		Connection conn = null;
		Statement stmt = null;
		//select 문 이라 rs 필요.
		ResultSet rs = null;
		try {
			Class.forName(driver);//1
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs= stmt.executeQuery(selectQuery);
			if(rs.next()) { //수정진행 란.
				
				System.out.print("수정할 부서의 이름은?");
				String dname = sc.next();
				System.out.print("수정할 부서의 위치는?");
				String loc = sc.next();
				
				String query = String.format("UPDATE DEPT SET DNAME='%s', LOC = '%s' WHERE DEPTNO=%s",
						dname, loc, deptno); //50을 스트링으로 받으니까 %s
				
				int result = stmt.executeUpdate(query);
				System.out.println(result >0? deptno+"부서 수정 성공" : "부서 수정 실패");
				
				
			}else {
				System.out.println("유효한 부서번호가 아닙니다. 수정을 종료 합니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
