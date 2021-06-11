package pra08.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * redirect 복습
 * first Servlet에서 요청을 받으면 second Servlet 실행
 */
@WebServlet("/praFirst")
public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		response.sendRedirect("praSecond");
		//sendRedirect() 메서드를 이용해 웹브라우저에게 다른 서블릿 second로 재요청
	}

}
