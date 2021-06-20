package pra09.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * �����ͺ��̽��� ����� ȸ���ΰ�,,
 * ������ �ڽ��� ȸ�� ���� ��ȸ ����(���� ����)
 */
@WebServlet("/pra09login3")
public class LoginServlet3 extends HttpServlet {

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
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();

		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		
		MemberVO vo = new MemberVO();
		vo.setId(user_id);
		vo.setPwd(user_pw);
		
		boolean result = dao.checkId(vo);

		if(result) {			
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("user_id", user_id);
			session.setAttribute("user_pw", user_pw);
			out.println("<html><body>");
			out.println("�ȳ��ϼ���!" + user_id + "��! <br>");
			out.println("<a href='pra09view2'>ȸ�� ���� ��ȸ</a>");
			out.println("</body></html>");
			
		}else {
			out.println("<a href='pra09login4.html'>���̵�� ��й�ȣ�� �����ʽ��ϴ�.");
		}


		
		
	}

}
