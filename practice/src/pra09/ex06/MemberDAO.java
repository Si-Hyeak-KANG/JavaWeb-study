package pra09.ex06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	Connection conn;
	PreparedStatement pstmt;
	DataSource dataFactory;
	
	public MemberDAO() {
		
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public boolean checkId(MemberVO memberVO) {
		boolean result = false;
		
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		
		try {
		
			conn = dataFactory.getConnection();
			//오라클의 decode() 함수를 이용해 조회하여 테이블에 존재하면 true, 존재하지 않으면 false.
			String query = "select decode(count(*),1,'true','false') as result from t_member"; 
			query += " where id=?";
			query += " and pwd=?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next(); // 커서를 첫 번째 레코드로 위치
			result = Boolean.parseBoolean(rs.getString("result"));
			
			System.out.println("result = " + result);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	


}
