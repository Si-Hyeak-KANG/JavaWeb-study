package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 디렉토리명만 일치하는 경우
 */
@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {
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
		out.println("<title>Tset Servlet2</title>");
		out.println("</head>");
		out.println("<body bgcolor='yellow'>");
		out.println("<b>TestServlet2 입니다.</b><br>");
		out.println("<b>컨텍스트명 : " + context + "</b><br>");
		out.println("<b>전체경로 : " + url + "</b><br>");
		out.println("<b>매핑명 : " + mapping + "</b><br>");
		out.println("<b>URI : " + uri + "</b>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	
	}

}
