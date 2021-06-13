package pra08.ex09;

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
				"/pra08sInit", 
				"/pra08sInit2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "zlcls456@naver.com"), 
				@WebInitParam(name = "tel", value = "010-111-1111")
		})
public class InitParamServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		out.println("<html><body>");
		out.println("<table><tr>");
		out.println("<td>email: </td><td>" + email + "</td></tr>");
		out.println("<td>tel: </td><td>" + tel + "</td></tr>");
		out.println("</table></body></html>");
	}

}
