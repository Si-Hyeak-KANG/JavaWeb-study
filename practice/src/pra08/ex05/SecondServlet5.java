package pra08.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet5
 */
@WebServlet("/pra08Second5")
public class SecondServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String address = (String)request.getAttribute("address");
		//전달된 request에서 getAttribute()를 이용해 address의 값을 가져옴.
		
		out.println("<html><body>");
		out.println("주소 : " + address); //null 출력
		out.println("<br>");
		out.println("redirect를 이용한 바인딩 실습");
		out.println("</body></html>");
		
		
	}

}
