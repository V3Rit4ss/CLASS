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
		System.out.print("������ �μ���ȣ��?");
		String deptno = sc.next(); // ��Ʈ�� 50 ���� ��. ����� ������ Ȥ�ó� �ϴ¸��� int�� int ��� �ϴ°� ����.
		
		
		
		//�Է��� �ش� �μ���ȣ�� �ִ��� ������ üũ.
		//dept2 �ڹ� ����.
		
		System.out.print("������ �μ��� �̸���?");
		String dname = sc.next();
		System.out.print("������ �μ��� ��ġ��?");
		String loc = sc.next();
//		System.out.println(1);
		//DB ����.
		Connection conn = null;
		Statement stmt = null;
//		System.out.println(2);
		String query = String.format("UPDATE DEPT SET DNAME='%s', LOC = '%s' WHERE DEPTNO=%s",
																			dname, loc, deptno); //50�� ��Ʈ������ �����ϱ� %s
		try {
			Class.forName(driver);//1.
//			System.out.println(3);   // ��� ������ ������ Ȯ���ϴ� ����� �ϳ�.
			conn = DriverManager.getConnection(url, "scott", "tiger");
//			System.out.println(4);
			stmt = conn.createStatement();
//			System.out.println(5);
			int result = stmt.executeUpdate(query);
			System.out.println(6);
			System.out.println(result > 0? deptno+"�� �μ� ���� ����" : "�ش� �μ� �������.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("���� ����.");
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
