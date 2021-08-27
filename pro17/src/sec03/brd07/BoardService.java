package sec03.brd07;

import java.util.List;

public class BoardService {
	
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	public List<ArticleVO> listArticles() {
		
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
	
	public int addArticle(ArticleVO articleVO) {
		
		return boardDAO.insertNewArticle(articleVO);
		
	}
	
	public ArticleVO viewArticle(int articleNO) {
		
		return boardDAO.selectArticle(articleNO);
	
	}
	
	public void modArticle(ArticleVO articleVO) {
		
		boardDAO.updateArticle(articleVO);
	}
	
	public List<Integer> removeArticle(int articleNO) {
		
		List<Integer> articleNOList = boardDAO.selectRemovedArticles(articleNO);
		boardDAO.deleteArticle(articleNO);
		return articleNOList
;	}
	
}
