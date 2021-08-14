package sec03.brd05;

import java.util.List;


public class BoardService {

	BoardDAO dao;

	public BoardService() {
		
		dao = new BoardDAO();
	}
	
	public List<ArticleVO> listArticles() {
		
		List<ArticleVO> articlesList = dao.selectAllArticles();
		
		return articlesList;
	}
	
	public int addArticle(ArticleVO articleVO) {
		
		return dao.insertNewArticle(articleVO);	
	}
	
	public ArticleVO viewArticle(int aritcleNO) {
		
		ArticleVO article = null;
		article = dao.selectArticle(aritcleNO);
		return article;
	}
	
}
