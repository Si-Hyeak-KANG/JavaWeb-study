package pra09.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class pra09login2
 */
@WebServlet("/pra09login2")
public class pra09login2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		HttpSession session = request.getSession();
		
		//������ ���� �����Ǿ��°�
		if(session.isNew()) {
			if(user_id != null) {
				session.setAttribute("user_id",user_id);
				out.println("<a href='pra09login2'>�α��� ���� Ȯ���ϱ�</a>");
			} else {
				out.println("<a href='pra09login2.html'>�ٽ� �α��� �ϼ���</a>");
				session.invalidate();
			}
			
		}else {
			//������ ���� �����Ǿ��� �� ���ε��ߴ� ���̵� ������ ������
			user_id = (String)session.getAttribute("user_id");
			
			//�α���â���� ���̵� ���� �α����ߴ°�
			if(user_id != null && user_id.length() != 0) {
				out.println("�ȳ��ϼ���" + user_id + "��!!!");
			}else {
				out.println("<a href='pra09login2.html'>�ٽ� �α��� �ϼ���!!</a>");
				session.invalidate();
			}
			
		}
	}

}
