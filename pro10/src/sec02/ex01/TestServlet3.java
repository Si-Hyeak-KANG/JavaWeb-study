package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 확장자가 있는 경우, .do로 하는 모든 요청을 처리 경우(디렉토리 우선)
 */
//@WebServlet("*.do")
//@WebServlet("/*")  // 모든 요청을 처리
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath(); // 컨텍스트명
		String url = request.getRequestURL().toString(); // 전체경로
		String mapping = request.getServletPath(); // 매핑명
		String uri = request.getRequestURI(); // uri
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Tset Servlet3</title>");
		out.println("</head>");
		out.println("<body bgcolor='red'>");
		out.println("<b>TestServlet3 입니다.</b><br>");
		out.println("<b>컨텍스트명 : " + context + "</b><br>");
		out.println("<b>전체경로 : " + url + "</b><br>");
		out.println("<b>매핑명 : " + mapping + "</b><br>");
		out.println("<b>URI : " + uri + "</b>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	
	}

}
