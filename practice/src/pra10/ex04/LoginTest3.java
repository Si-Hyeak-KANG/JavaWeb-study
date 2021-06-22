package pra10.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginTest3
 */
@WebServlet("/pra10login3")
public class LoginTest3 extends HttpServlet {

	List user_list = new ArrayList();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		ServletContext context = getServletContext();
		LoginImpl3 user_login = new LoginImpl3(user_id,user_pw);
		
		if(session.isNew()) {
			session.setAttribute("user_login", user_login);
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}
		
		out.println("<html><head>");
		out.println("<script type='text/javascript'>");
		out.println("setTime('history.go(0);',5000)");
		out.println("</script></head>");
		out.println("<body>");
		out.println("아이디 : " + user_login.user_id + "<br>");
		out.println("총 접속자 수 : " + user_login.total_user + "<br>");
		out.println("접속자 ID : <br>");
		
		List list = (ArrayList)context.getAttribute("user_list");
		
		for(int i=0; i<list.size(); i++) {
			out.println(list.get(i)+"<br>");
		
		}
		out.println("<a href='pra10logout2?user_id="+user_id+"'>로그아웃</a>");
		out.println("</body></html>");
			
		
	}

}
