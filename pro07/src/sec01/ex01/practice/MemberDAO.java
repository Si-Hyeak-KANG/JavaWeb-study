package sec01.ex01.practice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:this:@localhost:1521:XE";
	private static final String user = "c##scott";
	private static final String pwd = "tiger";
	
	private Connection con;
	private Statement stmt;
	
	public List<MemberVO> listMembers() {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			connDB();
			String query = "select * from t_member";
			System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
				stmt.close();
				con.close();
			}
			
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void connDB() {
		
		try {
			Class.forName(driver); //드라이버 로드
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd); //DriverManager.getConnection()으로 연결 얻기
			System.out.println("Connection 생성 성공");
			stmt = con.createStatement(); //connection 인스턴스를 이용해서 Statement 객체 생성
			System.out.println("Statement 생성 성공");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
