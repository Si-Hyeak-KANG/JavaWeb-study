package sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public List ListMembers(MemberVO memberVO) {
		
		List list = new ArrayList();
		String _name = memberVO.getName();
		try {
			conn = dataFactory.getConnection();
			String query = "select * from t_member";
			
			if(_name!=null || _name.length()!=0) {
				
				query += " where name=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, _name);
				
			}else {
				
				pstmt = conn.prepareStatement(query);
			}
			
			System.out.println("prepareStatement: " + query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				
				memberVO.setId(id);
				memberVO.setPwd(pwd);
				memberVO.setName(name);
				memberVO.setEmail(email);
				memberVO.setJoinDate(joinDate);
				
				list.add(memberVO);
				
				rs.close();
				pstmt.close();
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
