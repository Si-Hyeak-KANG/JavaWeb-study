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
			//����Ŭ�� decode() �Լ��� �̿��� ��ȸ�Ͽ� ���̺� �����ϸ� true, �������� ������ false.
			String query = "select decode(count(*),1,'true','false') as result from t_member"; 
			query += " where id=?";
			query += " and pwd=?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next(); // Ŀ���� ù ��° ���ڵ�� ��ġ
			result = Boolean.parseBoolean(rs.getString("result"));
			
			System.out.println("result = " + result);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	


}
