package sec03.brd06;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;


/**
 * Servlet implementation class BoardController
 */
@WebServlet(name = "BoardController6", urlPatterns = { "/board/*" })
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE_REPO = "C:\\article_image";
	BoardService boardService;
	ArticleVO articleVO;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String action = request.getPathInfo();
		System.out.println("action: " + action);
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			
			if (action == null) {
				
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList",articlesList);
				nextPage = "/board05/listArticles.jsp";
				
			} else if (action.equals("/board/listArticles.do")) {
				
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList",articlesList);
				nextPage = "/board05/listArticles.jsp";
						
			} else if (action.equals("/board/articleForm.do")) {
				
				nextPage = "/board05/articleFomr.jsp";
				
			} else if (action.equals("/board/addArticle.do")) {
				
				int articleNO = 0;
				Map<String,String> articleMap = upload(request,response);
				
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				
				articleVO.setParentNO(0);
				articleVO.setId("kange");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				articleNO = boardService.addArticle(articleVO);
				
				if (imageFileName != null && imageFileName.length() != 0) {
					
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				
				pw.println("<script>"
						+ " alert('������ �߰��߽��ϴ�.')"
						+ " location.href='"
						+ request.getContextPath()
						+ "/board/listArticles.do';"
						+ "</script>"
						);
				
				return;
				
			} else if (action.equals("/board/viewArticle.do")) {
				
				String articleNO = request.getParameter("articleNO");
				articleVO = boardService.viewArticle(Integer.parseInt(articleNO));
				request.setAttribute("article", articleVO);
				nextPage="/board05/viewArticle.jsp";
				
			} else if (action.equals("/board/modArticle.do")) {
				
				Map<String,String> articleMap = upload(request,response);
				int articleNO = Integer.parseInt(articleMap.get("articleNO"));
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				
				articleVO.setArticleNO(articleNO);
				articleVO.setParentNO(0);
				articleVO.setId("kang");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				
				boardService.modArticle(articleVO);
				
				if (imageFileName != null && imageFileName.length() != 0) {
					
					String originalFileName = articleMap.get("originalFileName");
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\"  + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					
					File oldFile = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO + "\\" + originalFileName);
					oldFile.delete();
				}
				
				pw.println("<script>"
						+ " alert('���� �����߽��ϴ�.')"
						+ " location.href('"
						+ request.getContextPath()
						+ "/board/listArticles.do';"
						+ "</script>"
						);
				
				return;
				
			} else if (action.equals("/board/removeArticle.do")) {
				
				int articleNO = Integer.parseInt(request.getParameter("articleNO"));
				List<Integer> articleNOList = boardService.removeArticle(articleNO);
				for(int _articleNO : articleNOList) {
					File imgDir = new File(ARTICLE_IMAGE_REPO + "\\" + _articleNO);
					
					if (imgDir.exists()) {
						FileUtils.deleteDirectory(imgDir);
					}
				}
				
				pw.println("<script>"
						+ " alert('���� �����߽��ϴ�.')"
						+ " location.href='"
						+ request.getContextPath() + "/board/listArticles.do';"
						+ "</script>"
						);
				
				
			} else {
				
				nextPage="/board05/listArticles.jsp";
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request,response);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Map<String,String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String> articleMap = new HashMap<String,String>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			
			List items = upload.parseRequest(request);
			
			for (int i = 0; i<items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
					
				} else {
					
					System.out.println("�Ķ���͸�: " + fileItem.getFieldName());
					System.out.println("����ũ��: " + fileItem.getSize());
					
					if (fileItem.getSize() > 0) {
						int idx= fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx + 1);
						System.out.println("���ϸ�:" + fileName);
						articleMap.put(fileItem.getFieldName(), fileName);
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile);
					}
					
					
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	
		return articleMap;
	}
}