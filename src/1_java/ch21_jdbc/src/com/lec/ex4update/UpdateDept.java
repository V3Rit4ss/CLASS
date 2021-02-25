package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 부서번호는?");
		String deptno = sc.next(); // 스트링 50 으로 들어감. 상관은 없지만 혹시나 하는맘에 int는 int 대로 하는게 좋음.
		
		
		
		//입력한 해당 부서번호가 있는지 없는지 체크.
		//dept2 자바 파일.
		
		System.out.print("수정할 부서의 이름은?");
		String dname = sc.next();
		System.out.print("수정할 부서의 위치는?");
		String loc = sc.next();
//		System.out.println(1);
		//DB 수정.
		Connection conn = null;
		Statement stmt = null;
//		System.out.println(2);
		String query = String.format("UPDATE DEPT SET DNAME='%s', LOC = '%s' WHERE DEPTNO=%s",
																			dname, loc, deptno); //50을 스트링으로 받으니까 %s
		try {
			Class.forName(driver);//1.
//			System.out.println(3);   // 어디서 오류가 나는지 확인하는 방법중 하나.
			conn = DriverManager.getConnection(url, "scott", "tiger");
//			System.out.println(4);
			stmt = conn.createStatement();
//			System.out.println(5);
			int result = stmt.executeUpdate(query);
			System.out.println(6);
			System.out.println(result > 0? deptno+"번 부서 수정 성공" : "해당 부서 존재안함.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("수정 실패.");
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
