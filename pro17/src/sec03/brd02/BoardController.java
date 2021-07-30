package sec03.brd02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardController
 */
@WebServlet(name = "BoardController2", urlPatterns = { "/board/*" })
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image"; // �ۿ� ÷���� �̹��� ���� ��ġ�� ����� ����
	BoardService boardService;
	ArticleVO articleVO;
	
	public void init(ServletConfig config) throws ServletException {

		boardService = new BoardService();
		articleVO = new ArticleVO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage= "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action: " + action);
		try {
			
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			
			if(action == null) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board02/listArticles.jsp";
				
			} else if (action.equals("/listArticles.do")) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board02/listArticles.jsp";
				
			} else if (action.equals("/articleForm.do")) { // ��û �� �۾���â�� ��Ÿ��
				nextPage = "/board02/articleForm.do";
			} else if (action.equals("/addArticle.do")) { // �� �� �߰� �۾��� ����
				
				Map<String, String> articleMap = upload(request, response); //���� ���ε� ����� ����ϱ� ���� upload()�� ��û
				
				//articleMap�� ����� �� ������ �ٽ� ������.
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				
				articleVO
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
				
	}


}
