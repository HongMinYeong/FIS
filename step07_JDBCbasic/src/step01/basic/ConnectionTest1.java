/*
 * 현업 구조 변환
 * 1. db의 접속 설정 정보를 자바 소스에서 분리
 * 2. 형식
 * 		url/id/pw등을 구분을 위한 고유한 별칭
 * 		key 와 value 구조
 * 		properties라는 확장자 파일로 주로 관리
 * 
 * 		spring에서도 설정에 대한 모든 내용이 properties파일로 분리외든 ㄴ근원
 * 
 * 3. 개발
 * 	1단계 : properties파일로 분리
 * 	2단계 : 자바 소스에서 해당 파일을 read하는 코드로 파일 인식
 * 	3단계 : properties 의 key 로 선별해서 매핑된 데이터 read후 사용
 * 
 * 4. io
 * 	1. 데이터 제공 근원지 (파일) 
 * 		1. 1byte 단위 read api
 * 			-FileInputStream
 * 		2. 2byte 단위 read api
 * 			-FileReader
 * 	2. property 파일로 부터 key 로 분리해서 read하는 주요 API
 * 		-Map 스펙 하위 클래스
 * 		- java.util.Properties 로 key 로 데이터 구분하면서 read
 * 
 * 5. 개발 고려사항
 * 	1. 파일이 존재?
 * 		- 파일없을 경우 - 비정상 종료 발생 가능성이 있음 , 해소 
 * 					- 예외처리를 사전에 적용 
 * 		- 파일 존재할 경우 - 정상
 * 	2. 파일 인식 단 내용물 key value 구조가 적합 
 * 	3. 코드상에서 정확히 key 사용 ? 
 */
package step01.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class ConnectionTest1 {

	// 파일 존재 및 활용 test
	@Test
	public void test() {
		try {
			// key로 value 뽑는 기능의 객체
			Properties p = new Properties();

			// new FileInputStream("db.properties") 파일로 부터 1byte 씩 read 가능
			p.load(new FileInputStream("db.properties"));
			
			/* 용어
			 * 변수 - field , variable, attribute, 속성, property
			 * 
			 */
			System.out.println(p.getProperty("jdbc.driver"));
			System.out.println("파일 read 성공 !0! ");
		} catch (FileNotFoundException e) {
			System.out.println("파일없음요");
			e.printStackTrace(); // 발생된 히스토리 확인
		} catch (IOException e) {
			System.out.println("IO문제 발생");
			e.printStackTrace();
		}
	}

	@Test
	public void oracleConnect() {
		String url = "";
		String user = "";
		String password = "";

		try {
			// JDBC 드라이버 로드
			Class.forName("");

			// 데이터베이스 연결
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Oracle 데이터베이스에 성공적으로 연결되었습니다.");

			// 연결 해제
			conn.close();
			System.out.println("연결이 성공적으로 해제되었습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Oracle 데이터베이스 연결 중 오류가 발생했습니다.");
			e.printStackTrace();
		}

		System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");

	}

//	@Test
//	public void mysqlConnect() {
//		// MYSQL 연결정보 설정
//		/*
//		 * jdbc :mysql ://localhost:3306/mydatabase jdbc : db 연동 java 표준 api의 통신 프로토콜 모든
//		 * db url에 필수로 반영 mysql : mysql 에서 제시한 db접속 url 표현 localhost:3306 : 실제 db가 실행되는
//		 * ip와 port 번호
//		 */
//		// MySQL 연결 정보 설정
//		String url = "jdbc:mysql://127.0.0.2:3306/fisa"; // MySQL 서버 URL (본인의 호스트 및 포트에 맞게 수정)
//		String user = "root"; // MySQL 사용자 이름
//		String password = "root"; // MySQL 비밀번호
//
//		try {
//			// JDBC 드라이버 로드
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			// 데이터베이스 연결
//			Connection conn = DriverManager.getConnection(url, user, password);
//			System.out.println("MySQL 데이터베이스에 성공적으로 연결되었습니다.");
//
//			// 연결 해제
//			conn.close();
//			System.out.println("연결이 성공적으로 해제되었습니다.");
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
//			e.printStackTrace();
//		} catch (SQLException e) {
//			System.out.println("MySQL 데이터베이스 연결 중 오류가 발생했습니다.");
//			e.printStackTrace();
//		}
//
//		System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");
//
//	}
}