package pra09.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ���� ��Ű ���
 */
@WebServlet("/pra09set2")
public class SetCookieValue2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date d = new Date();
		Cookie c = new Cookie("cookieTest2",URLEncoder.encode("JSP���α׷����Դϴ�.","utf-8"));
		c.setMaxAge(-1); // ��ȿ�ð��� ������ �����ϸ� Session ��Ű
		response.addCookie(c);
		
		out.println("���� �ð� : " + d);
		out.println("���� �ð��� Cookie�� �����մϴ�.");
	}

}
