package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

//ServletContext, HttpSession, Request 각각의 Scope 확인
@WebServlet("/pro10Get")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		String ctxMesg = (String) ctx.getAttribute("context");
		String sesMesg = (String) session.getAttribute("session");
		String reqMesg = (String) request.getAttribute("request");
		
		out.print("context값 : " + ctxMesg + "<br>"); //모든 어플리케이션에서 접근이 가능한 scope -> 다른 브라우저에서도 바인딩 가능
		out.print("session값 : " + sesMesg + "<br>"); // 세션은 서블릿끼리 바인딩 scope
		out.print("request값 : " + reqMesg + "<br>"); // 서블릿끼리 다른 값 => request 값 : null 
	}

}
