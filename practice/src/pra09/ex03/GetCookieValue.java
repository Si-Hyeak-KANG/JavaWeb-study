package pra09.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 서블릿에서 쿠키 사용하기
 */
@WebServlet("/pra09get")
public class GetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] allValues = request.getCookies();
		
		for(int i=0; i<allValues.length; i++) {
			
			if(allValues[i].getName().equals("cookieTest")) {
				out.println("<h2>Cookie 값 가져오기 : " + URLDecoder.decode(allValues[i].getValue(),"utf-8"));
			}
		}
	}
	
}
