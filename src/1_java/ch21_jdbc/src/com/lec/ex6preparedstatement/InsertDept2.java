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

		String insertSql = "INSERT INTO DEPT VALUES ( ? , ? , ? )"; // ( ? , ? , ? )=> ���� , ( ? ,' ? ', ? ) => �Ұ���.
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO= ? ";

		System.out.print("�߰� �� �μ���ȣ��?");
		int deptno = sc.nextInt();
		// �ش� �μ���ȣ�� �ִ��� Ȯ���� �μ��߰�
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			if (!rs.next()) { //rs.next �� �ƴҶ� �߰�����.
				 System.out.print("�߰� �� �μ��̸���?"); 
				 String dname = sc.next();
				  System.out.print("�߰� �� �μ���ġ��?"); 
				  sc.nextLine(); 
				  String loc = sc.nextLine();
				  
				  rs.close(); //pstmt�� rs�� ���⿡ �Ѵ� close.
				  pstmt.close(); //�Ʒ� pstmt�� ���� ����� ���ؼ� ����.
				  
				  pstmt = conn.prepareStatement(insertSql);
				  pstmt.setInt(1, deptno);
				  pstmt.setString(2, dname);
				  pstmt.setString(3, loc);
				  
				  int result = pstmt.executeUpdate();
				  System.out.println(result>0? deptno+"�� �μ� �߰� ����" : "�μ� �߰� ����");
			}else {
				System.out.println("�ߺ��� �μ���ȣ�� �߰��� �Ұ��մϴ�.");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(deptno + "�� �߰� ����"); //�����ִ� ���׿������� ���� �κ��� �Ϸο�.
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
		