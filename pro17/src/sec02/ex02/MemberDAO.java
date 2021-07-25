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

	private Connection conn;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		
		try {
			System.out.println("dao 생성");
			
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//회원(리스트) 정보 조회
	public List<MemberVO> listMembers() {
		
		List<MemberVO> list = new ArrayList();
		
		try {
			conn = dataFactory.getConnection();
			String query = "select * from t_member order by joinDate desc";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO(id,pwd,name,email,joinDate);
				
				list.add(vo);
			}
			
			rs.close();
			pstmt.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 회원 정보 생성
	public void addMember(MemberVO memberVO) {
		
		try {
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			conn = dataFactory.getConnection();
			String query = "insert into t_member(id,pwd,name,email)" + " values(?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 수정할 회원의 정보 검색
	public MemberVO findMember(String _id) {
		
		MemberVO memInfo = null;
		
		try {
			conn = dataFactory.getConnection();
			String query = "select * from t_member where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _id);
			System.out.println(query);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			
			memInfo = new MemberVO(id, pwd, name, email, joinDate);
			
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return memInfo;
	}
	
	// 회원 정보 수정
	public void modMember(MemberVO memberVO) {
		
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		
		try {
			conn = dataFactory.getConnection();
			String query = "update t_member set pwd=?,name=?,email=? where id=?";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	// 회원 정보 삭제
	public void delMember(String id) {
		
		try {
			conn = dataFactory.getConnection();
			String query = "delete from t_member where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
