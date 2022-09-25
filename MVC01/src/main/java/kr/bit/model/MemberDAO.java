package kr.bit.model;
// JDBC -> MyBatis, JPA

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// 데이터베이스 연결 객체 생성
	public void getConnect() throws ClassNotFoundException, SQLException {
		String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "";

		// MySQL Driver Loading
		Class.forName("com.mysql.jdbc.Driver"); // 동적 로딩
		conn = DriverManager.getConnection(URL, user, password); // MySQL 에 접속을 시도, 성공하면 연결정보를 넘겨줌
		
	}
}
