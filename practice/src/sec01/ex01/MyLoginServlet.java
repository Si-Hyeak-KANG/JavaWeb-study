package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyLoginServlet
 */
@WebServlet("/mylogin")
public class MyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		
		String command = request.getParameter("command");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(command != null || command.equals("login")) {
			
			if(dao.CheckId(id) == 0) {
				out.print("<html><title>�α��� ����</title><body>");
				out.print("<font size='20' color='red'>���̵� �߸��Ǿ����ϴ�.</font>");
				out.print("<br>");
				out.print("<a href='http://localhost:8091/practice/login.html'>�α���â���� ���ư���</a>");
				out.print("</body></html>");
			}
			
			else if(dao.CheckPwd(pwd) == 0) {
				out.print("<html><title>�α��� ����</title><body>");
				out.print("<font size='20' color='red'>��й�ȣ�� �߸��Ǿ����ϴ�.</font>");
				out.print("<br>");
				out.print("<a href='http://localhost:8091/practice/login.html'>�α���â���� ���ư���</a>");
				out.print("</body></html>");	
			}
			
			else{
				System.out.println(id+"���� �α��� �Ǿ����ϴ�.");
				response.sendRedirect("http://localhost:8091/practice/home.html");	

			}
						
		}
	}

}
