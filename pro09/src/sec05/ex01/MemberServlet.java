package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/pro09Login4")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		
		MemberDAO dao = new MemberDAO();
		
		boolean result = dao.isExisted(memberVO);
		
		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);
			out.print("<html><body>");
			out.print("�ȳ��ϼ��� " + user_id + "��!!!<bt>");
			out.print("<a href='show'>ȸ������ ����</a>");
			out.print("</body></html>");
		
		}else {
			out.print("<html><body><center>ȸ�� ���̵� Ʋ���ϴ�.");
			out.print("<a href='login3.html'>�ٽ� �α����ϱ�</a> ");
			out.print("</body></html>");
		}
		
	}

}
