package step01.basic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class ConnectionProperty2 {
	/*
	 * 경우의 수 1. 정상 실행 - 검색정보 client 에게 제공 2. 비정상 실행 - client 에게 상황은 반드시 언급 - 검색 데이터는
	 * 정상 응답 불가 - 실행 유지..? ---- 개발 코드 관점에서 필수 항목 - 자원 반환 필수 - try ~ catch try ~
	 * catch ~ finally try ~ finally
	 * 
	 * 
	 */

	@Test
	public void connect() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 데이터베이스 연결
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM dept");

			while(rs.next()) {
//				System.out.println(rs.getInt("deptno"));

				System.out.println(rs.getInt("deptno") + " | " 
									+ rs.getString(2) + " | " 
									+ rs.getString(3));
			}
		} finally { // 예외 발생 여부와 무관하게 100% 실행, 신뢰영역
			DBUtil.close(conn, stmt, rs);

		}
//		System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");
	}

	@Test
	public void connect2() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 데이터베이스 연결
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM dept");

		} catch (SQLException e) {
			e.printStackTrace(); // 발생된 예외 상황 콘솔엥 출력
			throw e;
		} finally { // 예외 발생 여부와 무관하게 100% 실행, 신뢰영역
			DBUtil.close(conn, stmt, rs);

		}
//		System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");
	}
}