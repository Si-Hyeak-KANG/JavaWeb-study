package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/pro09login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}


	public void destroy() {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		String data = "�ȳ��ϼ���!<br> �α����ϼ̽��ϴ�.<br><br>";
		data +="<html><body>";
		data +="���̵� : " + user_id;
		data +="<br>";
		data +="��й�ȣ : " + user_pw;
		data +="<br>";
		data +="�ּ� :" + user_address;
		data +="<br>";
		data +="email : " + user_email;
		data +="<br>";
		data +="�޴� ��ȭ : " + user_hp;
		data +="</body></html>";
		out.print(data);
		
		user_address = URLEncoder.encode(user_address,"utf-8");
		out.print("<a href='/pro09/pro09second?user_id="+user_id
					+ "&user_pw=" + user_pw
					+ "&user_address=" + user_address
					+ "'>�ι�° �������� ������</a>");
			
		}

}
