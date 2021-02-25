package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; // DB연결 객체 변수
		Statement stmt = null; // SQL 전송 객체 변수
		ResultSet rs = null; // SELECT 문 결과 받는 객체 변수
		String sql = "SELECT * FROM EMP";
		try {  //select 문은  executeQuery
			Class.forName(driver); // 1. 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger");// 2. DB 연결 객체 생성
			stmt = conn.createStatement(); // 3. SQL 전송 객체 생성.
			rs = stmt.executeQuery(sql); // 4. stmt.~~ <= SQL 전송 하고 + 5. rs <= SQL전송결과 받기.
			// 6. 결과 받아서 원하는 로직 수행하기. - rs 에 있는 데이터 콘솔에 출력.
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t급여\t상여금\t부서번호");
			while (rs.next()) {
				int empno = rs.getInt("empno"); // "empno" 는 타이틀 이름. or 1,2 숫자로도 넣는거 가능. 스트링으로 받아도 오류 안남.
				String ename = rs.getString("ename"); // but 숫자로 넣으면 가독성 저하.
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
//				Date hiredate = rs.getDate("hiredate"); //데이트 형으로 받아도 스트링형으로 받아도 댐. 
//				String hiredate = rs.getString("hiredate");
				Timestamp hiredate = rs.getTimestamp("hiredate"); // 이렇게 해도 된다.
				int sal = rs.getInt("sal"); // 소수점이있으면 더블로 받아와라.
				int comm = rs.getInt("comm"); // null값은 인트형으로 와서 0으로 출력댐.
				int deptno = rs.getInt("deptno");
				if (job != null && job.length() < 7) {
					System.out.printf("%d\t %s\t %s\t\t %d\t %TF\t %d\t %d\t %d\n", // 데이트나 타임스텝은 %TF
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
				} else {
					System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n", // 데이트나 타임스텝은 %TF
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
				}

			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// close 는 생성한 방법의 역순으로
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
