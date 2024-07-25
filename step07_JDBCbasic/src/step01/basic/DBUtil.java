package step01.basic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	private static Properties p = new Properties();

	static {
		try {
			p.load(new FileInputStream("db.properties"));
			Class.forName(p.getProperty("jdbc.driver"));
		} catch (Exception e) {
			System.out.println("IO문제 발생");
			e.printStackTrace();
		}
	}

	// 접속 객체 생성해서 반환
	// db 접속 문제자체를 호출한 곳으로 처리 위임
	// 접속 문제 -> ... -> controller 에세 접속 이슈 관련된 유연한 처리 유도
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.id"),
				p.getProperty("jdbc.pw"));

	}

	// 예외 발생시 null 반환
//	public static Connection getConnection2() {
//		Connection conn = null;
//		try {
//			return DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.id"),
//					p.getProperty("jdbc.pw"));
//
//		} catch (SQLException e) {
//			
//		}
//		return conn;
//	}

	// select 용 자원반환 메소드
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// i/u/d 용 자원반환 메소드
	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
