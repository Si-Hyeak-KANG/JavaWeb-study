package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest3
 */
@WebServlet("/sess3")
public class SessionTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		out.println("���� ���̵�: " + session.getId() + "<br>");
		out.println("���� ���� ���� �ð�: " + new Date(session.getCreationTime()) + "<br>");
		out.println("�ֱ� ���� ���� �ð�: " + new Date(session.getLastAccessedTime()) + "<br>");
		out.println("���� ��ȿ �ð�: " + session.getMaxInactiveInterval() + "<br>");
		if (session.isNew()) {
			out.print("�� ������ ����������ϴ�.");
		}
		session.invalidate();  //������ ������ ���� ��ü�� ������ ����
		
	}

}
