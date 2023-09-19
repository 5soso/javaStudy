package t10_sale_me;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	ProductVO pVO = null;
	SaleVO sVO = null;
	
//	public SaleDAO() { //싱글톤이 아니라서, db를 할 때마다 열림. productdao에만들어놨음.
//		String url = "jdbc:mysql://localhost:3306/javaProject";
//		String user = "atom";
//		String password = "1234";
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			conn = DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 검색 실패~~" + e.getMessage());
//		} catch (SQLException e) {
//			System.out.println("데이터베이스 연동 실패~~" + e.getMessage());
//		}
//	}
	
	// pstmt객체 close
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {}
	}
	
	// rs객체 close
	public void rsClose() {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {}
		pstmtClose();
	}
	
}
