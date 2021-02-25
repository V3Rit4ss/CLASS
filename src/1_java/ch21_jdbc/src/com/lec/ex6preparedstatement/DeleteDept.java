package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//1. ������ �μ���ȣ�� �Է� �޾Ƽ�, 2. (�Է���  �μ���ȣ�� ���� ���)"��¥�� ������ �μ��� �����Ͻðڽ��ϱ�?"
//3. y : ����   -> �����Ϸ� �޼���.  , n(�׿�) : �������ϰ� ����.
//4. �Է��� �μ���ȣ�� ������ ���ٰ� �ϰ� ����.
public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �μ���ȣ��?");
		int deptno = sc.nextInt();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO= ?";  //(�Է��� �μ���ȣ ã��.)
		String delteSql = "SELECT * FROM DEPT WHERE DEPTNO= ?"; //(�Է��� �μ���ȣ ����.)
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url ,"scott","tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();//pstmt �� () �ȿ� �ƹ��͵� �ȳ���.
			if(rs.next()) { //���� ���� Ȯ��.
				System.out.print(deptno+"�� �μ��� ������ ���� �Ͻðڽ��ϱ�?");
				String answer = sc.next();
				if(answer.equalsIgnoreCase("y")) { //�亯 Ȯ���ؼ� ����.
					rs.close();
					pstmt.close();
					
					pstmt = conn.prepareStatement(delteSql);
					pstmt.setInt(1, deptno);
					int result = pstmt.executeUpdate();
					System.out.println(result >0? deptno+"�� ���� ����" : "���� ����.");
				}
				
				
			}else {
				System.out.println("�ش� �μ���ȣ�� �μ��� �������� �ʽ��ϴ�.");
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
