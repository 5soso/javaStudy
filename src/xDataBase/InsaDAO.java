package xDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsaDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	InsaVO vo = null;
	
	public InsaDAO() {
		String url = "jdbc:mysql://localhost:3306/javaProject";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// Connection Closing
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	//pstmt Closing
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {}
	}
	
	//rs Closing
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			rs.close();
		} catch (SQLException e) {}
		pstmtClose();
	}

	//회원명 검색(회원 중복처리)
	public InsaVO getNameSearch(String name) {
		vo = new InsaVO();
		try { //3박자 
			sql = "select * from insa where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //자료가 있으면,
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			//e.printStackTrace();
		} finally {
			rsClose();
		}
		return vo;
	}

	//회원가입 처리
	public int setInsaInput(InsaVO vo) {
		int res = 0; //에러가 있으면 한번도 실행을 안 하기 때문에 0이 넘어간다.
		try {
			sql = "insert into insa value (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
}
