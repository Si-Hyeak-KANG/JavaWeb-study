package sec01.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> ListMembers() {
		
		MemberVO vo = new MemberVO();
		List<MemberVO> list = new ArrayList<>();
		
		try {
			con = dataFactory.getConnection();
			String query = "select * from mcfc_table";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String position = rs.getString("position");
				
				
				
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setGender(gender);
				vo.setPosition(position);
				
				list.add(vo);
			}
		
			pstmt.close();
			rs.close();
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public int CheckId(String id) {
		
		int num = 0;
		
		try {
			con = dataFactory.getConnection();
			String query = "select id from mcfc_table";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String voId = rs.getString("id");
				
				if( voId.equals(id)) {
					num = 1;	
				}
				
				
			}
			
			pstmt.close();
			con.close();
			rs.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return num;
		
		
	}
	
	public int CheckPwd(String pwd) {
		
		int num = 0;
		
		try {
			con = dataFactory.getConnection();
			String query = "select pwd from mcfc_table";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String voPwd = rs.getString("pwd");
				
				if( voPwd.equals(pwd)) {
					num = 1;	
				}
				
				
			}
			
			pstmt.close();
			con.close();
			rs.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return num;
		
		
	}
	
}
	

	
	
