package pra10.ex03;

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
 * HttpSessionListener을 이용해 로그인 접속자수와 접속자 ID를 표시
 */
@WebServlet("/pra10login2")
public class LoginTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List user_list = new ArrayList(); //로그인한 접속자 ID를 저장하는 ArrayList

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServletContext context = getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl2 loginUser = new LoginImpl2(user_id,user_pw);
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
			
			out.println("<html><body>");
			out.println("아이디는 " + loginUser.user_id + "<br>");
			out.println("총 접속자 수는 " + loginUser.total_user + "<br>");
			out.println("접속자 아이디 :<br>");
			List list = (ArrayList)context.getAttribute("user_list");
			for(int i=0; i<list.size(); i++) {
				out.println(list.get(i) + "<br>");
				
			}
			
			out.println("<a href='pra10logout?user_id="+user_id+"'>로그아웃</a>");
			out.println("</body></html>");
		}
	}

}
