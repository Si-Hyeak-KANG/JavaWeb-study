package pra09.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet2
 */
@WebServlet("/pra09second")
public class SecondServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		
		out.println("<html><body>");
		if(user_id != null && user_id.length() != 0) {
			out.println("�̹� �α��� �����Դϴ�!!<br><br>");
			out.println("ù ��° �������� �Ѱ��� ���̵�: " + user_id + "<br>");
			out.println("ù ��° �������� �Ѱ��� ��й�ȣ: " + user_pw + "<br>");
			out.println("ù ��° �������� �Ѱ��� �ּ�: " + user_address + "<br>");
			out.println("</body></html>");
		}else {
			
			out.println("�α��� ���� �ʽ��ϴ�.<br><br>");
			out.println("�ٽ� �α����ϼ���!!<br>");
			out.println("<a href='/practice/pra09login.html");
			
		}
			
	}

}
