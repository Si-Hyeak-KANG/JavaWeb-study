package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
//@WebServlet(name = "SecondServlet2", urlPatterns = { "/second" })
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String address = (String)request.getAttribute("address");
		
		out.print("<html><body>");
		out.print("주소 : " + address); //redirect를 이용한 바인딩은 null이 나온다.
		out.print("<br>");
		out.print("redirect를 이용한 바인딩 실습"); 
		out.print("</body></html>");
	}

}
