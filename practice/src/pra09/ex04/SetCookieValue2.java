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
 * 세션 쿠키 사용
 */
@WebServlet("/pra09set2")
public class SetCookieValue2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date d = new Date();
		Cookie c = new Cookie("cookieTest2",URLEncoder.encode("JSP프로그래밍입니다.","utf-8"));
		c.setMaxAge(-1); // 유효시간을 음수로 지정하면 Session 쿠키
		response.addCookie(c);
		
		out.println("현재 시간 : " + d);
		out.println("현재 시간을 Cookie로 저장합니다.");
	}

}
