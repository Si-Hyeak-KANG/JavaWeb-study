package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import sec01.ex02.MemberVO;

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
	
	public List listMembers() {
		
		List list = new ArrayList();
		
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member order by joinDate desc"; // 회원 정보를 최근 가입일 순으로 조회
			System.out.println("prepareStatement: " + query);
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
	
	public List ListMembers(MemberBean memberBean) {
		
		List list = new ArrayList();
		String _name = memberBean.getName();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			
			if(_name!=null || _name.length()!=0) {
				
				query += " where name=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, _name);
				
			}else {
				
				pstmt = con.prepareStatement(query);
			}
			
			System.out.println("prepareStatement: " + query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				
				memberBean.setId(id);
				memberBean.setPwd(pwd);
				memberBean.setName(name);
				memberBean.setEmail(email);
				memberBean.setJoinDate(joinDate);
				
				list.add(memberBean);
				
				rs.close();
				pstmt.close();
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void addMember(MemberBean memberBean) {
		
		try {
			
			Connection con = dataFactory.getConnection();
			
			String id = memberBean.getId();
			String pwd = memberBean.getPwd();
			String name = memberBean.getName();
			String email = memberBean.getEmail();
			
			String query = "insert into t_member";
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
