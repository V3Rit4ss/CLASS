package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*사용자에게 원하는 부서번호를 입력 받아
(1) 해당 부서번호가 존재하는경우 : 부서정보 출력 , 사원이 존재하는 경우 리스트 출력, 존재하지 않을경우 사원이 없다고 출력.
						사원(사번,이름,급여, 부서번호) 출력.
(2)해당 부서번호가 존재하지 않는경우 : 존재하지 않는 부서번호 출력.
*
*
*/
public class SelectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 부서번호는?");
		int deptno = sc.nextInt();
		String query1 ="SELECT * FROM DEPT WHERE DEPTNO = "+deptno;
		String query2 ="SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE DEPTNO="+deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query1);
			
			if(rs.next()) {
				System.out.println("원하는 부서번호 : "+deptno);
				System.out.println("원하는 부서명 "+rs.getString("dname"));
				System.out.println("원하는 부서 위치 "+rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(query2);
				if(rs.next()) {
					System.out.println("사번\t이름\t급여\t부서번호");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal      = rs.getInt("sal");
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+deptno);
					}while (rs.next());
				}else {
					System.out.println(deptno+"번 부서사원은 없습니다.");
				}
			}else {
				System.out.println("유효하지 않는 부서번호 입니다.");
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
