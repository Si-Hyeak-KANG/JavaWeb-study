package sec04.ex03;

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
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			System.out.println("MemberDAO 持失切 持失");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> ListMembers() {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
		
			
			
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			
			while(rs.next()) {
				
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO memberVO = new MemberVO();
				memberVO.setId(id);
				memberVO.setPwd(pwd);
				memberVO.setName(name);
				memberVO.setEmail(email);
				memberVO.setJoinDate(joinDate);
				
				list.add(memberVO);
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void AddMember(MemberVO memberVO) {
		
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		
		try {
			con = dataFactory.getConnection();
			String query = "insert into t_member";
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";
			
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, email);
			pstmt.setString(4, name);
			
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DelMember(String id) {
		
		try {
			con = dataFactory.getConnection();
			String query = "delete from t_member"+" where id=?";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


