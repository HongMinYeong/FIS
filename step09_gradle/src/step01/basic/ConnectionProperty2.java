package step01.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import db.util.DBUtil;

public class ConnectionProperty2 {
	/*
	 * 경우의 수 1. 정상 실행 - 검색정보 client 에게 제공 2. 비정상 실행 - client 에게 상황은 반드시 언급 - 검색 데이터는
	 * 정상 응답 불가 - 실행 유지..? ---- 개발 코드 관점에서 필수 항목 - 자원 반환 필수 - try ~ catch try ~
	 * catch ~ finally try ~ finally
	 * 
	 * 
	 */

//	@Test
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

	//insert into dept values (55, 'a','b')
	@Test
	public void connect2() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 데이터베이스 연결
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement("INSERT INTO dept VALUES(?,?,?)");
			pstmt.setInt(1,16); // 첫번째 파라미터에 15 
			pstmt.setString(2, "교육부");
			pstmt.setString(3, "상암");
			
			//실제 DB에 SQL실행 메소드 
			int result = pstmt.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace(); // 발생된 예외 상황 콘솔엥 출력
			throw e;
		} finally { // 예외 발생 여부와 무관하게 100% 실행, 신뢰영역
			DBUtil.close(conn, pstmt);

		}
//		System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");
	}
}