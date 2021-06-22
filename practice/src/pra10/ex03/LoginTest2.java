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
 * HttpSessionListener�� �̿��� �α��� �����ڼ��� ������ ID�� ǥ��
 */
@WebServlet("/pra10login2")
public class LoginTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List user_list = new ArrayList(); //�α����� ������ ID�� �����ϴ� ArrayList

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
			out.println("���̵�� " + loginUser.user_id + "<br>");
			out.println("�� ������ ���� " + loginUser.total_user + "<br>");
			out.println("������ ���̵� :<br>");
			List list = (ArrayList)context.getAttribute("user_list");
			for(int i=0; i<list.size(); i++) {
				out.println(list.get(i) + "<br>");
				
			}
			
			out.println("<a href='pra10logout?user_id="+user_id+"'>�α׾ƿ�</a>");
			out.println("</body></html>");
		}
	}

}
