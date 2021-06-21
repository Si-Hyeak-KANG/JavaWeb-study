package pra10.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class GetAttribute
 */
@WebServlet("/pra10get")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		String ctxMesg = (String)ctx.getAttribute("context");
		String sesMesg = (String)session.getAttribute("session");
		String reqMesg = (String)request.getAttribute("request");
		
		out.print("context°ª : " + ctxMesg + "<br>");
		out.print("session°ª : " + sesMesg + "<br>");
		out.print("request°ª : " + reqMesg + "<br>");
	}

}
