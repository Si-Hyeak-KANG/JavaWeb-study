package pra09.ex03;

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
 * �������� ��Ű ����ϱ�
 */
@WebServlet("/pra09set")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=urf-8");
		PrintWriter out = response.getWriter();
		
		Date d = new Date();
		
		Cookie c = new Cookie("cookieTest",URLEncoder.encode("JSP���α׷����Դϴ�.","utf-8"));
		c.setMaxAge(24*60*60);
		response.addCookie(c);
		
		out.println("����ð� : " +d);
		out.println("���ڿ��� Cookie�� �����մϴ�.");
	}
	
	

}
