package pra08.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * redirect ����
 * first Servlet���� ��û�� ������ second Servlet ����
 */
@WebServlet("/praFirst")
public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		response.sendRedirect("praSecond");
		//sendRedirect() �޼��带 �̿��� ������������ �ٸ� ���� second�� ���û
	}

}
