package sec03.brd06;

import java.util.List;

public class BoardService {
	
	BoardDAO boardDAO();
	
	public List<ArticleVO> listArticls() {
		
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
	
	public int addArticle(ArticleVO articleVO) {
		
		return boardDAO.insertNewArticle();
		
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
