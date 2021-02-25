package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//�μ����� �Է¹޾� �ش� �μ��� ������ ��� ����Ʈ ��� (���, �̸�, �޿� , �޿����.)
public class SelectWhereDname2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �μ�����?");
		String dname = sc.next();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
	//	sql = String.format("SELECT * FROM DEPT WHERE DNAME='%s'", dname);
		
		String query1 = String.format("SELECT * FROM DEPT WHERE DNAME='%s'",dname);
		 String query2 = String.format
				 ("SELECT EMPNO,ENAME,SAL,GRADE FROM EMP E, DEPT D, SALGRADE WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND DNAME='%s'",dname);
		
		 try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query1);
			if(rs.next()) {
				System.out.println("�μ���ȣ : "+rs.getInt("empno"));
				System.out.println("�μ��̸� : "+dname);
				System.out.println("�μ���ġ : "+rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(query2);
				if(rs.next()) {
					System.out.println("���\t�̸�\t�޿�\t�޿����");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int grade = rs.getInt("grade");
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+grade);
						
					}while (rs.next()) ;
					
				}else {
					System.out.println("�ش� �μ��� ����� �������� �ʽ��ϴ�.");
				}
				
			}else {
				System.out.println("�ش� �μ��̸��� ���������ʽ��ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null ) rs.close();
				if(stmt != null ) stmt.close();
				if(conn != null ) conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		 
		 
		 
		 
	}
}
