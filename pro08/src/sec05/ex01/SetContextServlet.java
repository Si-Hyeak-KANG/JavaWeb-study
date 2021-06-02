package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetContextServlet
 */
@WebServlet("/cset")
public class SetContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	*/
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		
		List member = new ArrayList();
		member.add("이순신");
		member.add(30);
		context.setAttribute("member", member);
		
		out.print("<html><body>");
		out.print("이순신과 30 바인딩");
		out.print("</body></html>");
	}

}
