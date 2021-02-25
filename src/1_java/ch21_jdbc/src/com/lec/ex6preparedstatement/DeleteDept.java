package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//1. 삭제할 부서번호를 입력 받아서, 2. (입력한  부서번호가 있을 경우)"진짜로 ㅁㅁ번 부서를 삭제하시겠습니까?"
//3. y : 삭제   -> 삭제완료 메세지.  , n(그외) : 삭제안하고 종료.
//4. 입력한 부서번호가 없으면 없다고 하고 종료.
public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 부서번호는?");
		int deptno = sc.nextInt();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO= ?";  //(입력한 부서번호 찾기.)
		String delteSql = "SELECT * FROM DEPT WHERE DEPTNO= ?"; //(입력한 부서번호 삭제.)
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url ,"scott","tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();//pstmt 라서 () 안에 아무것도 안넣음.
			if(rs.next()) { //삭제 진행 확인.
				System.out.print(deptno+"번 부서를 정말로 삭제 하시겠습니까?");
				String answer = sc.next();
				if(answer.equalsIgnoreCase("y")) { //답변 확인해서 진행.
					rs.close();
					pstmt.close();
					
					pstmt = conn.prepareStatement(delteSql);
					pstmt.setInt(1, deptno);
					int result = pstmt.executeUpdate();
					System.out.println(result >0? deptno+"번 삭제 성공" : "삭제 실패.");
				}
				
				
			}else {
				System.out.println("해당 부서번호의 부서는 존재하지 않습니다.");
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e){
				
			}
		}
	}
}
