package sec03.brd03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




public class BoardDAO {

	private DataSource dataFactory;
	Connection conn;
	PreparedStatement pstmt;
	
	public BoardDAO() {
		
		try {
		Context ctx = new InitialContext();
		Context envContext = (Context) ctx.lookup("java:/comp/env");
		dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//전체 게시글 조회
	public List<ArticleVO> selectAllArticles() {
		
		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
		
		try {
			conn = dataFactory.getConnection();
			
			// 오라클의 계층형 SQL문을 실행
			String query = "SELECT LEVEL, articleNO, parentNO, title, content, id, writeDate"
							+ " from t_board"
							+ " START WITH parentNO=0"
							+ " CONNECT BY PRIOR articleNO=parentNO"
							+ " ORDER SIBLINGS BY articleNO DESC";
			
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int level = rs.getInt("level");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				
				ArticleVO vo = new ArticleVO();
				vo.setLevel(level);
				vo.setArticleNO(articleNO);
				vo.setParentNO(parentNO);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setId(id);
				vo.setWriteDate(writeDate);
				
				articlesList.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return articlesList;
	}
	
	// 새 글 번호 조회
	public int getNewArticleNO() {
		
		try {
			
			conn = dataFactory.getConnection();
			String query = "SELECT max(articleNO) from t_board";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			//조회된 가장 큰 번호에 1을 더한 번호를 반환
			if(rs.next()) {
				return(rs.getInt(1) + 1);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// 새 글 쓰기
	public int insertNewArticle(ArticleVO vo) {
		
		int articleNO = getNewArticleNO();
		try {
			
			int parentNO = vo.getParentNO();
			String title = vo.getTitle();
			String content = vo.getContent();
			String id = vo.getId();
			String imageFileName = vo.getImageFileName();
			
			conn = dataFactory.getConnection();
			String query = "insert into t_board (articleNO, parentNO, title, content, imageFileName, id)"
							+ " values(?,?,?,?,?,?)";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, parentNO);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return articleNO;
	}
}
