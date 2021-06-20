package pra09.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewServlet2
 */
@WebServlet("/pra09view2")
public class ViewServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Boolean isLogon = false;
		
		//이미 세션이 존재하면 세션을 반환, 없으면 null 반환
		HttpSession session = request.getSession(false);
		if(session != null) {
			isLogon=(Boolean)session.getAttribute("isLogon"); //isLogon 속성을 가져와 로그인 상태 확인
			
			if(isLogon==true) {
				String id = (String)session.getAttribute("user_id");
				String pwd = (String)session.getAttribute("user_pw");
				
				out.println("<html><body>");
				out.println("id : " + id +"<br>");
				out.println("pwd : " + pwd + "<br>");
				out.println("</html></body>");
	
				
			}else {
				response.sendRedirect("pra09login4.html");
			}
		} else {
			response.sendRedirect("pra09login4.html");
		}
		
	}




}
