package sec01.ex01;

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
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원 조회
	public List<MemberVO> ListMembers() {
		
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			con = dataFactory.getConnection();
			String query = "select * from mcfc_table ";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			
			while (rs.next()) {
				
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String position = rs.getString("position");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setGender(gender);
				vo.setPosition(position);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
			}
		
			rs.close();
			pstmt.close();
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//로그인 아이디 체크
	public int CheckId(String id) {
		
		int num = 0;
		
		try {
			con = dataFactory.getConnection();
			String query = "select id from mcfc_table";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			
			while(rs.next()) {
				
				String voId = rs.getString("id");
				
				if( voId.equals(id)) {
					num = 1;	
				}
				
				
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return num;
		
		
	}
	
	//로그인 비밀번호 체크
	public int CheckPwd(String pwd) {
		
		int num = 0;
		
		try {
			con = dataFactory.getConnection();
			String query = "select pwd from mcfc_table";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			
			while(rs.next()) {
				
				String voPwd = rs.getString("pwd");
				
				if( voPwd.equals(pwd)) {
					num = 1;	
				}
				
				
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return num;
			
	}
	
	//회원가입
	public void addMember(MemberVO memberVO) {
		
		try {
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			//String gender = memberVO.getGender();
			//String position = memberVO.getPosition();
			
			con = dataFactory.getConnection();
			String query = "insert into mcfc_table";
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
	
	//회원 삭제
	public void delMember(String id) {
		
		try {
			con = dataFactory.getConnection();
			String query = "delete from mcfc_table" + " where id =?";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			pstmt.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	


	
	
}
	

	
	
