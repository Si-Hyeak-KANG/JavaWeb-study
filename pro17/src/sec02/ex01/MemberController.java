package sec02.ex01;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet(name = "MemberController2", urlPatterns = { "/member/*" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDAO memberDAO;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MemberDAO();
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
		
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getPathInfo(); // URL에서 요청명을 가져옴
		System.out.println("action:" + action);
		
		if(action == null || action.equals("/listMembers.do")) {  // 최초 요청이거나 action 값이 /listMembers.do면 회원 목록 출력
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList",membersList);
			nextPage = "/test02/listMembers.jsp";
			
		}else if(action.equals("/addMember.do")) { // action 값이 /addMember.do면 전송된 회원 정보를 가져와서 테이블에 추가
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO memberVO = new MemberVO(id,pwd,name,email);
			memberDAO.addMember(memberVO);
			nextPage = "/member/listMembers.do"; // 회원 등록 후 다시 회원 목록을 출력
			
		}else if(action.equals("/memberForm.do")) { // action 값이 /memberForm.do면 회원 가입창을 화면에 출력
			
			nextPage = "/test02/memberForm.jsp";
			
		} else { // 그 외 다른 action 값은 회원 목록을 출력
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request,response);
			
	}

}
