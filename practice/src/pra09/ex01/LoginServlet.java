package pra09.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <hidden> �±׸� �̿��� ���� Ʈ��ŷ �ǽ� ����
 */
@WebServlet("/pra09login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		String email = request.getParameter("user_email");
		String hp = request.getParameter("user_hp");
		
		String data="�ȳ��ϼ���!<br> �α����ϼ̽��ϴ�.<br><br>";
		data += "<html><body>";
		data += "���̵� : " + id;
		data += "<br>";
		data += "��й�ȣ : " + pwd;
		data += "<br>";
		data += "�ּ� : " + address;
		data += "<br>";
		data += "email : " + email;
		data += "<br>";
		data += "hp : " + hp;
		
		out.println(data);
		
				
	}
	
	public void destroy()
	{
		System.out.println("destroy �޼��� ȣ��");
	}
}
