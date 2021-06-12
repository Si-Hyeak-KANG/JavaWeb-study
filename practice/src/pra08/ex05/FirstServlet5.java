package pra08.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * HttpServletRequest�� �̿��� redirect ���ε�
 */
@WebServlet("/pra08First5")
public class FirstServlet5 extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		request.setAttribute("address","���� ����"); //�� ���������� ��û�� request��ü�� address�� ������ "���� ����"�� ���ε�
		response.sendRedirect("pra08Second5");
		
		
	}

}
