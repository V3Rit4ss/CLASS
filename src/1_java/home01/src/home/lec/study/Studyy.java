package home.lec.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class Studyy {
	public static void main(String[] args) {
		String driver = "";
		String url = "";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "scott", "tiget");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
