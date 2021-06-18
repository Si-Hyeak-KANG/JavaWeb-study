package pra09.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * ���� API �̿� 
 */
@WebServlet("/pra09sess")
public class SessionTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//getSession()�� ȣ���Ͽ� ���� ��û �� ���� ��ü�� ���� �����ϰų� ���� ������ ��ȯ
		HttpSession session = request.getSession(); 
		out.println("���� ���̵� : "+ session.getId()+"<br>"); // ������ ���� ��ü�� id�� ������.
		
		out.println("���� ���� ���� �ð�: "+ new Date(session.getCreationTime())+"<br>"); //���� ���� ��ü ���� �ð��� ������
		out.println("�ֱ� ���� ���� �ð� : " + new Date(session.getLastAccessedTime())+"<br>"); // ���� ��ü�� ���� �ֱٿ� ������ �ð��� ������
		out.println("���� ��ȿ �ð� : " +session.getMaxInactiveInterval()+"<br>"); // ���� ��ü�� ��ȿ �ð��� ������
		
		//���� ������ �������� �Ǻ�
		if(session.isNew()) {
			out.println("�� ������ ����������ϴ�.");
		}
		
	}

}
