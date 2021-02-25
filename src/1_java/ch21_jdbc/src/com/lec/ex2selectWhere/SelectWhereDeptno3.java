package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*����ڿ��� ���ϴ� �μ���ȣ�� �Է� �޾�
(1) �ش� �μ���ȣ�� �����ϴ°�� : �μ����� ��� , ����� �����ϴ� ��� ����Ʈ ���, �������� ������� ����� ���ٰ� ���.
						���(���,�̸�,�޿�, ����) ���.
(2)�ش� �μ���ȣ�� �������� �ʴ°�� : �������� �ʴ� �μ���ȣ ���.
*
*
*/
public class SelectWhereDeptno3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �μ���ȣ��?");
		int deptno = sc.nextInt();
		String query1 ="SELECT * FROM DEPT WHERE DEPTNO = "+deptno;
		String query2 ="SELECT W.EMPNO, W.ENAME, W.SAL ,M.ENAME manager FROM EMP W, EMP M WHERE W.MGR=M.EMPNO AND W.DEPTNO = "+deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query1);
			
			if(rs.next()) {
				System.out.println("���ϴ� �μ���ȣ : "+deptno);
				System.out.println("���ϴ� �μ��� "+rs.getString("dname"));
				System.out.println("���ϴ� �μ� ��ġ "+rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(query2);
				if(rs.next()) {
					System.out.println("���\t�̸�\t�޿�\t����");
					do {
						int empno = rs.getInt("empno");        //sql���� ����� Ÿ��Ʋ �̸��� �����ͼ� ���°�.
						String ename = rs.getString("ename");
						int sal      = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+manager+"\t");
					}while (rs.next());
				}else {
					System.out.println(deptno+"�� �μ������ �����ϴ�.");
				}
			}else {
				System.out.println("��ȿ���� �ʴ� �μ���ȣ �Դϴ�.");
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
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		
	}
}
