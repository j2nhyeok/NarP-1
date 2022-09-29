package kr.bit.model;
// JDBC -> MyBatis, JPA

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// 데이터베이스 연결 객체 생성
	public void getConnect() {
		// 데이터 베이스 접속 URL
		String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "";

		// MySQL Driver Loading
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password); // MySQL 에 접속을 시도, 성공하면 연결정보를 넘겨줌
		} catch (Exception e) {
			e.printStackTrace();
		} // 동적 로딩(실행 시점에서 객체를 생성하는 방법)
	}

	// 회원 저장 동작
	public int memberInsert(MemberVO vo) {
		//																 ?(파라메터) 1, 2, 3, 4, 5, 6
		String SQL = "INSERT INTO member(id, pass, name, age, email, phone) values(?, ?, ?, ?, ?, ?)";
		getConnect();
		
		// SQL문장을 전송하는 객체 생성
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL); // MySQL에서 미리 컴파일을 시킨다. -> 미리 컴파일 시키기 때문에 속도가 빨라진다.
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			
			// 성공하면 1, 실패하면 0
			 cnt = ps.executeUpdate(); //전송(실행), insert경우 추가되는 것이므로, update가 되어야 함.
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return cnt; 
	}
	
	// 회원(VO) 전체 리스트(ArrayList) 가져오기
	public ArrayList<MemberVO> memberList() {
		String SQL = "SELECT * FROM member";
		getConnect();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery(); // 데이터베이스에 변화가 없으므로 update X. query O.  / rs => 커서
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				
				MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone);
				list.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}

		return list;
	}
	
	// 특정 회원 삭제
	public int memberDelete(int num) {
		String SQL = "DELETE FROM member WHERE num = ?";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	// 데이터베이스 연결 끊기
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
