package step01.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MySQLConnectionExample {
	
	@Test
	public void oracleConnect() {
        String url = "jdbc:oracle:thin:@127.0.0.2:1521:xe"; 
        String user = "scott"; 
        String password = "tiger"; 

        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

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
	
	
	@Test
	public void mysqlConnect() {
    	//MYSQL 연결정보 설정
    	/*
    	 * jdbc :mysql ://localhost:3306/mydatabase
    	 * jdbc : db 연동 java 표준 api의 통신 프로토콜 
    	 * 모든 db url에 필수로 반영
    	 * mysql : mysql 에서 제시한 db접속 url 표현
    	 * localhost:3306 : 실제 db가 실행되는 ip와 port 번호
    	 */
    	   // MySQL 연결 정보 설정
        String url = "jdbc:mysql://127.0.0.2:3306/fisa"; // MySQL 서버 URL (본인의 호스트 및 포트에 맞게 수정)
        String user = "root"; // MySQL 사용자 이름
        String password = "root"; // MySQL 비밀번호

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("MySQL 데이터베이스에 성공적으로 연결되었습니다.");

            // 연결 해제
            conn.close();
            System.out.println("연결이 성공적으로 해제되었습니다.");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("MySQL 데이터베이스 연결 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
        
        System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");
        
    }
}