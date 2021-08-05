package sec03.brd04;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import sec03.brd04.ArticleVO;

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
	
	//��ü �Խñ� ��ȸ
	public List<ArticleVO> selectAllArticles() {
		
		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
		
		try {
			conn = dataFactory.getConnection();
			
			// ����Ŭ�� ������ SQL���� ����
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
	
	// �� �� ��ȣ ��ȸ
	public int getNewArticleNO() {
		
		try {
			
			conn = dataFactory.getConnection();
			String query = "SELECT max(articleNO) from t_board";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			//��ȸ�� ���� ū ��ȣ�� 1�� ���� ��ȣ�� ��ȯ
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
	
	// �� �� ����
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
	
	// �Խñ� �� ��ȸ
	public ArticleVO selectArticle(int articleNO) {
		
		ArticleVO article = new ArticleVO();
		try {
			conn = dataFactory.getConnection();
			String query = "select articleNO,parentNO,title,content,imageFileName,id,writeDate"
						+ " from t_board"
						+ " where articleNO=?";
		
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,articleNO);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			int _articleNO = rs.getInt(articleNO);
			int  parentNO = rs.getInt("parentNO");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = rs.getString("imageFileName");
			String id = rs.getString("id");
			Date writeDate = rs.getDate("writeDate");
			
			article.setArticleNO(_articleNO);
			article.setParentNO(parentNO);
			article.setTitle(title);
			article.setContent(content);
			article.setImageFileName(imageFileName);
			article.setId(id);
			article.setWriteDate(writeDate);
			
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return article;
	}
}
