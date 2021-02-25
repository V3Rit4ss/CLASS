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
		System.out.print("�߰� �� �μ���ȣ��?");
		int deptno = sc.nextInt();
		System.out.print("�߰� �� �μ��̸���?");
		String dname = sc.next();
		System.out.print("�߰� �� �μ���ġ��?");
		sc.nextLine();
		String loc = sc.nextLine();
		//DB���� �Ͽ� insert ����.
		String sql = "INSERT INTO DEPT VALUES ( ? , ? , ? )"; // ( ? , ? , ? )=> ���� , ( ? ,' ? ', ? ) => �Ұ���.
		
		Connection conn = null;
		PreparedStatement pstmt = null;   
		
		try {
			Class.forName(driver); //1
			conn = DriverManager.getConnection(url, "scott" , "tiger");
			pstmt = conn.prepareStatement(sql); //��
//			stmt = conn.createStatement(); //�Ʒ� : ���� �Ʒ��� ������.
			pstmt.setInt(1, deptno); // deptno ������ ��Ʈ���̶��. setString.  ,  int �� setInt.
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
//			int result = stmt.executeUpdate(sql);
			int result = pstmt.executeUpdate();
			System.out.println(result >0? deptno+"�� �Է� ����" : "�Է� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(deptno+"�� �Է½���");  // �Է½��з� ���� ���� null �̶� �Ϸ� ����������.
		} finally {
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
		
		
			}
		}
	}
}