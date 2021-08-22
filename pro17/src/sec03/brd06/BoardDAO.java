package sec03.brd06;

import java.net.URLEncoder;
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
			System.out.println("dao»ý¼º");
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ArticleVO> selectAllArticles() {
		
		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
		
		try {
			conn = dataFactory.getConnection();
			String query = "select LEVEL, articleNO, parentNO, title, content, id, writeDate from t_board"
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
				
				ArticleVO articleVO = new ArticleVO();
				articleVO.setLevel(level);
				articleVO.setArticleNO(articleNO);
				articleVO.setParentNO(parentNO);
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setId(id);
				articleVO.setWriteDate(writeDate);
				
				articlesList.add(articleVO);
				
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articlesList;
	}
	
	public int getNewArticleNO() {
		
		try {
			
			conn = dataFactory.getConnection();
			String query = "select max(articleNO) from t_board";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			if (rs.next())
				return (rs.getInt(1) + 1);
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int insertNewArticle(ArticleVO articleVO) {
	
		int articleNO = getNewArticleNO();
		
		try {
			int parentNO = articleVO.getParentNO();
			String title = articleVO.getTitle();
			String content = articleVO.getContent();
			String id = articleVO.getId();
			String imageFileName = articleVO.getImageFileName();
			
			conn = dataFactory.getConnection();
			String query = "insert into t_board (articleNO, parentNO, title, content, imageFileName, id)"
						+ " values (?,?,?,?,?,?)";
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
	
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articleNO;
	}
	
	public ArticleVO selectArticle(int articleNO) {
		ArticleVO article  = new ArticleVO();
		try {
			conn = dataFactory.getConnection();
			String query = "select articleNO, parentNO, title, content, NVL(imageFileName,'null') as imageFileName, id, writeDate"
						+ " from t_board"
						+ " where articleNO=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int _articleNO = rs.getInt("articleNO");
			int parentNO = rs.getInt("parentNO");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = URLEncoder.encode(rs.getString("imageFileName"),"UTF-8");
			if(imageFileName.equals("null")) {
				imageFileName = null;
			}
			
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return article;
	}
	
	public void updateArticle(ArticleVO articleVO) {
		
		int articleNO = articleVO.getArticleNO();
		String title = articleVO.getTitle();
		String content = articleVO.getContent();
		String imageFileName = articleVO.getImageFileName();
		
		try {
			conn = dataFactory.getConnection();
			String query = "update t_board set title=?, content=?";
			if (imageFileName != null && imageFileName.length() != 0) {
				query += ",imageFileName=?";
			}
			query += "where articleNO=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			if (imageFileName != null && imageFileName.length() != 0) {
				pstmt.setString(3, imageFileName);
				pstmt.setInt(4, articleNO);
			} else {
				pstmt.setInt(3, articleNO);
			}
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteArticle(int articleNO) {
		
		try {
			conn = dataFactory.getConnection();
			String query = "delete form t_board";
			query += " WHERE articleNO in(";
			query += " SELECT articleNO FROM t_board ";
			query += " START WITH articleNO =?";
			query += " CONNECT BY PRIOR articleNO=parentNO )";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Integer> selectRemovedArticles(int articleNO) {
		
		List<Integer> articleNOList = new ArrayList<Integer>();
		
		try {
			conn = dataFactory.getConnection();
			String query = "select articleNO from t_board";
			query += " START WITH articleNO = ?";
			query += " CONNECT BY PRIOR articleNO = parentNO";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				articleNO = rs.getInt("articleNO");
				articleNOList.add(articleNO);
			}
			rs.close();
			pstmt.close();
			conn.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articleNOList;
	}
}
