package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(
		urlPatterns = { 
				"/sInit", 
				"/sInit2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "admin@test.com"), 
				@WebInitParam(name = "tel", value = "010-1111-2222")
		})
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
	
		out.print("<html><body>");
		out.print("<table><tr>");
		out.print("<td>eamil:</td><td>" + email + "</td></tr>");
		out.print("<tr><td>�޴���ȭ��ȣ: </td><td> " + tel + "</td>");
		out.print("</tr><table></body></html>");
	}

}
