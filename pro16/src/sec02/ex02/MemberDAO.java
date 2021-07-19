package sec02.ex02;

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
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		
		try {
			
		Context ctx = new InitialContext();
		Context envContext = (Context) ctx.lookup("java:/comp/env");
		dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 아이디 중복 체크 여부
	public boolean overlappedID(String id) {
		
		boolean result = false;
		
		try {
			con = dataFactory.getConnection();
			String query = "select decode(count(*),1,'true','false')as result from t_member";
			query += " where id =?";
			System.out.println("prepareStatement: " +query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//회원 정보 조회
	public List listMembers() {
		
		List list = new ArrayList();
		
		try {
			con=dataFactory.getConnection();
			String query = "select * from t_member order by joinDate desc";
			System.out.println("preparestatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberBean bean = new MemberBean();
				bean.setId(id);
				bean.setPwd(pwd);
				bean.setName(name);
				bean.setEmail(email);
				bean.setJoinDate(joinDate);
				
				
				list.add(bean);
			}
			rs.close();
			pstmt.close();
			con.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
