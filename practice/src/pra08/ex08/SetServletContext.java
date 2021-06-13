package pra08.ex08;

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

/**
 * SetServletContext Ŭ���� : 
 * 
 * getServletContext() �޼��带 �̿���  ServletContext ��ü�� ���� �� ArrayList�� �̸��� ���̸� ������ ��
 * �ٽ� ServletContext ��ü�� setAttribute() �޼��带 �̿��� ���ε�
 */
@WebServlet("/pra08cset")
public class SetServletContext extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		List member = new ArrayList();
		member.add("�̼���");
		member.add(30);
		context.setAttribute("member",member);
		
		out.println("<html><body>");
		out.println("�̼��Ű� 30 ����");
		out.println("</body></html>");
	}


}
