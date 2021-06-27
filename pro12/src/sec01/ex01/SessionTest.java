package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * ���� ���ε�
 */
@WebServlet("/pro12sess")
public class SessionTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("name","�̼���");
		
		out.println("<html><body>");
		out.println("<h1>���ǿ� �̸��� ���ε��մϴ�.</h1>");
		out.println("<a href='/pro12/test01/session1.jsp'>ù ��° �������� �̵�</a>");
		out.println("</body></html>");
	}

}
