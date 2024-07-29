/* DAO 클래스 
 * - dept01 table 과 매핑되는 db 연동 클래스 
 * 
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import db.util.DBUtil;
import model.domain.Dept01DTO;

public class Dept01DAO {
	// 모든 부서 정보 검색
	/*
	 * PreparedStatement API 특징 - db에 요청이 되면 문장 받고 -> 문법 검증 -> 실행 매순간 요청시 마다 : 검증 작업
	 * 수행 - Statement 최초 받고 매 요청시 재사용 : preparedStatement
	 * 
	 * - JPA & mybatis 라는 db 연동 framework 들의 기본 API로 내부적으로 사용
	 */
	@Test
	public void junitTest() {
		try {
//			System.out.println(getDept01All());
//			System.out.println(getDept01One(10));
			System.out.println(saveDept01(new Dept01DTO(50, "hong", "SEOUL")));
			// [Dept01DTO(deptno=10, dname=ACCOUNTING, loc=NEW YORK), Dept01DTO(deptno=20,
			// dname=RESEARCH, loc=DALLAS), Dept01DTO(deptno=30, dname=SALES, loc=CHICAGO),
			// Dept01DTO(deptno=40, dname=OPERATIONS, loc=BOSTON)]
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	@Test //반환 타입이 있는 것은 단위테스트 적합 x 
	public ArrayList<Dept01DTO> getDept01All() throws SQLException {
		// 선언 먼저
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dept01DTO> datas = null;

		try {
			con = DBUtil.getConnection(); // 오라클 연결
			pstmt = con.prepareStatement("select * from dept01");

//		    DEPTNO DNAME                LOC
//		---------- -------------------- --------------------
//		        10 ACCOUNTING           NEW YORK
//		        20 RESEARCH             DALLAS
//		        30 SALES                CHICAGO
//		        40 OPERATIONS           BOSTON

			rs = pstmt.executeQuery(); // 실제 실해은 resultset 으로 받기

			datas = new ArrayList<>(); // 자원 낭비로 try 문 밖에서 null 로 선언후 안에서 생성

			while (rs.next()) {// 반복 횟수가 불 명확할 때 주로 사용되는 반복문
				// 데이터 컬럼 대로 뽑고
				// DTO 생성
				// ArrayList에 DTO add
				datas.add(new Dept01DTO(rs.getInt(1), rs.getString("dname"), rs.getString("LOC")));
//				datas.add(new Dept01DTO(rs.getInt(1),rs.getString("dname"),rs.getString(3))) ;

			}

			// 데이터 존재 여부검증은 어떻게 ?

		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		return datas;
	}

	// 하나의 부서번호로 검색
	/*
	 * 필요 데이터 : deptno 반환 값 : Dept01DTO client -> view : 데이터 입력 -> controller : 입력
	 * 여부 검증 -> controller : 입력 여부 검증 -> 입력이 되었을 경우만 실행되게 작업
	 * 
	 */
	public Dept01DTO getDept01One(int deptno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept01DTO datas = null;

		try {
			// 데이터베이스 연결
			con = DBUtil.getConnection();

			// SQL 쿼리 작성 (deptno에 따라 특정 행을 선택)
			pstmt = con.prepareStatement("SELECT * FROM dept01 WHERE deptno = ?");

			// deptno 값 설정
			pstmt.setInt(1, deptno);

			// 쿼리 실행
			rs = pstmt.executeQuery();

			// 결과 처리
			if (rs.next()) { // 결과가 있는 경우
				datas = new Dept01DTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
			}
		} finally {
			// 리소스 해제
			DBUtil.close(con, pstmt, rs);
		}

		return datas;
	}

	// 새로운 부서 정보 저장
	public boolean saveDept01(Dept01DTO dept01dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = DBUtil.getConnection(); // 데이터베이스 연결
			pstmt = con.prepareStatement("INSERT INTO dept01 (deptno, dname, loc) VALUES (?, ?, ?)");
			pstmt.setInt(1, dept01dto.getDeptno());
			pstmt.setString(2, dept01dto.getDname());
			pstmt.setString(3, dept01dto.getLoc());

			int rowsAffected = pstmt.executeUpdate(); // 쿼리 실행

			if (rowsAffected > 0) {
				result = true;
			}
		} finally {
			DBUtil.close(con, pstmt); // 리소스 해제
		}
		return result;
	}
}
