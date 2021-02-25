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
		System.out.print("������ �μ���ȣ��?");
		String deptno = sc.next(); // ��Ʈ�� 50 ���� ��. ����� ������ Ȥ�ó� �ϴ¸��� int�� int ��� �ϴ°� ����.
		
		//�Է��� �ش� �μ���ȣ�� �ִ��� ������ üũ.
		String selectQuery = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		Connection conn = null;
		Statement stmt = null;
		//select �� �̶� rs �ʿ�.
		ResultSet rs = null;
		try {
			Class.forName(driver);//1
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs= stmt.executeQuery(selectQuery);
			if(rs.next()) { //�������� ��.
				
				System.out.print("������ �μ��� �̸���?");
				String dname = sc.next();
				System.out.print("������ �μ��� ��ġ��?");
				String loc = sc.next();
				
				String query = String.format("UPDATE DEPT SET DNAME='%s', LOC = '%s' WHERE DEPTNO=%s",
						dname, loc, deptno); //50�� ��Ʈ������ �����ϱ� %s
				
				int result = stmt.executeUpdate(query);
				System.out.println(result >0? deptno+"�μ� ���� ����" : "�μ� ���� ����");
				
				
			}else {
				System.out.println("��ȿ�� �μ���ȣ�� �ƴմϴ�. ������ ���� �մϴ�.");
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
