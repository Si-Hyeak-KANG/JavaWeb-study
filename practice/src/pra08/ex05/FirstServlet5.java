package pra08.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * HttpServletRequest를 이용한 redirect 바인딩
 */
@WebServlet("/pra08First5")
public class FirstServlet5 extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		request.setAttribute("address","제주 제주"); //웹 브라우저에서 요청한 request객체에 address의 값으로 "제주 제주"를 바인딩
		response.sendRedirect("pra08Second5");
		
		
	}

}
