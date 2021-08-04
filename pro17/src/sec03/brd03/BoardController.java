package sec03.brd03;

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
@WebServlet(name = "BoardController3", urlPatterns = { "/board/*" })
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE_REPO="C:\\article_image"; //글에 첨부한 이미지 저장 위치를 상수로 선언
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
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getPathInfo(); // URL에서 요청명을 가져옴
		System.out.println("action: " + action);
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			
			if(action == null) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board02/listArticles.jsp";	
			}
			else if(action.equals("/listArticles.do")) {
			// action 값 /listArticles.do 요청 시 게시글 목록 조회	
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board02/listArticles.jsp";
			}
			else if(action.equals("/articleForm.do")) {
			// action 값 /articleForm.do 요청 시 글쓰기 창 호출	
				nextPage = "/board02/articleForm.jsp";
			}
			else if(action.equals("/addArticle.do")) {
				
				int articleNO = 0;
				Map<String, String> articleMap = upload(request,response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				
				articleVO.setParentNO(0);
				articleVO.setId("kang");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				articleNO = boardService.addArticle(articleVO); //테이블에 새 글을 추가한 후 새 글에 대한 글번호를 가져옴.
				
				if (imageFileName != null && imageFileName.length() != 0) {
					
					//temp 폴더에 임시로 업로드된 파일 객체를 생성
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					
					//CURR_IMAGE_REPO_PATH의 경로 하위에 글 번호로 폴더 생성
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
					destDir.mkdirs();
					
					//temp 폴더의 파일을 글 번호를 이름으로 하는 폴더로 이동시킴
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('새 글을 추가했습니다.');"
									+ " location.href='"
									+ request.getContextPath()
									+ "/board/listArticles.do';"
						+"</script>");
				
				return;

			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private Map<String,String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String> articleMap = new HashMap<String, String>();
		
		String encoding = "utf-8";
		
		//글 이미지 저장 폴더에 대해 파일 객체 생성
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for(int i=0; i<items.size(); i++) {
				
				FileItem fileItem = (FileItem) items.get(i);
				
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					
					//파일 업로드로 같이 전송된 새 글 관련 매개변수를 Map에 (key,value)로 저장한 후 반환하고, 새 글과 관련된 title,content를 Map에 저장
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				}
				else {
					System.out.println("파라미터이름: " + fileItem.getFieldName());
					System.out.println("파일이름: " + fileItem.getName());
					System.out.println("파일크기: " + fileItem.getSize()+"bytes");
					
					
					//업로드한 파일이 존재하는 경우 업로드한 파일의 파일 이름으로 저장소에 업로드
					if(fileItem.getSize()>0) {
						
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx+1);
						
						// 업로드된 파일의 파일 이름을 Map에("imageFileName","업로드파일이름")로 저장
						articleMap.put(fileItem.getFieldName(), fileName);
						
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return articleMap;
		
	}

}
