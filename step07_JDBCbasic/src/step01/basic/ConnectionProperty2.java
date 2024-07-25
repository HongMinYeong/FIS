package step01.basic;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class ConnectionProperty2 {

	private static Properties p = new Properties();

	@Test
	public void connect() {
		String url = p.getProperty("jdbc.url");
		String user = p.getProperty("jdbc.id");
		String password = p.getProperty("jdbc.pw");

		try {
			// 데이터베이스 연결
			Connection conn = DBUtil.getConnection();
			System.out.println("데이터베이스에 성공적으로 연결되었습니다.");
			// 연결 해제
			conn.close();
			System.out.println("연결이 성공적으로 해제되었습니다.");

		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 중 오류가 발생했습니다.");
			e.printStackTrace();
		}

		System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");

	}
}