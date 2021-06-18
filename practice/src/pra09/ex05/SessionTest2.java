package pra09.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * ���� ��ȿ �ð� �缳��
 */
@WebServlet("/pra09sess2")
public class SessionTest2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.println("���� ���̵� : " + session.getId());
		out.println("���� ���� ���� �ð� : " + new Date(session.getCreationTime()) + "<br>");
		out.println("�ֱ� ���� ���� �ð� : " + new Date(session.getLastAccessedTime())+"<br>");
		out.println("�⺻ ���� ��ȿ �ð� : " + session.getMaxInactiveInterval() + "<br>");
		session.setMaxInactiveInterval(5); //������ ��ȿ �ð��� 5�ʷ� ����
		out.println("���� ��ȿ �ð� : " + session.getMaxInactiveInterval() + "<br>");
		
		if(session.isNew()) {
			out.print("�� ������ ����������ϴ�.");
		}
	}

}
