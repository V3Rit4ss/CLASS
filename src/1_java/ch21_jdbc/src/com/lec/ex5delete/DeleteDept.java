package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 부서번호는?");
		int deptno = sc.nextInt();
		Connection conn = null;
		Statement stmt = null; //sql 문 쏠꺼니까.
		//delete 라서 rs 필요없음.
		
		String deleteSql = "DELETE FROM DEPT WHERE DEPTNO="+deptno;
		try {
			Class.forName(driver);//1
			conn = DriverManager.getConnection(url, "scott" , "tiger");
			stmt = conn.createStatement(); 
			int result = stmt.executeUpdate(deleteSql);
			
			if(result >0) {
				System.out.println(deptno+"번 부서 삭제완료");
			
			}else {
				System.out.println(deptno+"번 부서는 존재하지 않습니다.");
			}
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}//close 문의 try catch
		}//db접속 try- catch
	}//main
}//class
