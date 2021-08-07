package sec03.brd04;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	private DateSource dataFactory;
	Connenction conn;
	PreparedStatement pstmt;
	
	public BoardDAO() {
		
		try {
			
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc:/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ArticleVO> selectAllArticles() {
		
		try { 

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
