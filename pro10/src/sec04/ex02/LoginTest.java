package sec04.ex02;

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
 * Servlet implementation class LoginTest
 */
@WebServlet("/pro10Login3")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServletContext context = null;
	List user_list = new ArrayList();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		context = getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}
		
		out.println("<html><body>");
		out.println("아이디는 " + loginUser.user_id + "<br>");
		out.println("총 접속자수는 " + LoginImpl.total_user + "<br><br>");
		out.println("접속 아이디: <br>");
		
		List list = (ArrayList) context.getAttribute("user_list");
		for(int i=0; i<list.size();i++) {
			out.println(list.get(i) + "<br>");
		}
		out.println("<a href='pro10Logout?user_id="+ user_id + "'>로그아웃</a>");
		out.println("</body></html>");
	
	}

}
