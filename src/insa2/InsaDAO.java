package insa2;

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
		String passworsd = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, passworsd);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패 : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	//connClose()
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	//pstmtClose()
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {}
	}
	
	//rsClose()
	public void rsClose() {
		try {
			if(rs != null) rs.close();
		} catch (SQLException e) {
			pstmtClose();
		}
	}

	//회원명 검색(회원 중복처리) 
	//InsaInput 클래스에서 가입하기 버튼 코드짜던 중에(213라인에서) 필요해서 만들어졌음.
	public InsaVO getNameSearch(String name) { //타입이 InsaVO인 이유는 형식이다.. 리턴 할 때 타입 : InsaVO 
		vo = new InsaVO(); // 생성을 해야지 vo에 담을 수 있음..
		try { //DB관련된 것은 항상 try catch 예외처리 할 것.
			sql = "select * from insa where name = ?"; //DB에 저장된 이름 중 어떤 이름을 보여줘야할지 모르기때문에 조건부의 이름 값에 '?' 사용
			pstmt = conn.prepareStatement(sql); //connection은 자바랑 데이터베이스랑 연결만 해줌. 
			pstmt.setString(1, name); //인덱스번지 쓰는 법 : sql가서 DB 구조 보면 됨 //1번 인덱스번지(=Name)에, 입력받은 이름을 넣어라
			rs = pstmt.executeQuery(); //반환값(=출력값)이 있다. // rs - executeQuery 문법외우기
			
			if(rs.next()) { //자료가 있으면,
				vo.setIdx(rs.getInt("idx")); //()안에는 레코드필드명? // rs로 읽은 idx 값을 vo에 저장해라
				vo.setName(rs.getString("name")); //getString = 컬럼타입, name = 컬럼타입
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose(); //DB를 읽고, 출력을 했으니까 다 읽었으면 닫야야됨.
		}
		return vo; //sql문으로 DB에서 읽은 값을 VO에 담아라.
	}

	//회원가입 처리 
	public int setInsaInput(InsaVO vo2) { //타입을 int로 하는 이유? res가 0이면 받는 게 없고, res가 1이면 받은게 있다는 뜻? 
		int res = 0;
		try {
			sql = "insert into insa value (defualt,?,?,?,?)";
			pstmt = conn.prepareStatement(sql); //위의 sql문을 DB에서 읽지 못 하니까, prepareStatement가 sql문을 읽어서 DB에 값을 넣어준다..
			pstmt.setString(1, vo.getName());
			pstmt.setInt(1, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			res = pstmt.executeUpdate(); //입력값을 res로 넘겨준다.
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose(); //pstmt로 sql문을 읽어서 DB에 회원을 등록했으니까 pstmt닫아주기.. 
		}
		return res;
	}
}
