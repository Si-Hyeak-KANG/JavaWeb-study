package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Ȯ���ڰ� �ִ� ���, .do�� �ϴ� ��� ��û�� ó�� ���(���丮 �켱)
 */
//@WebServlet("*.do")
//@WebServlet("/*")  // ��� ��û�� ó��
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath(); // ���ؽ�Ʈ��
		String url = request.getRequestURL().toString(); // ��ü���
		String mapping = request.getServletPath(); // ���θ�
		String uri = request.getRequestURI(); // uri
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Tset Servlet3</title>");
		out.println("</head>");
		out.println("<body bgcolor='red'>");
		out.println("<b>TestServlet3 �Դϴ�.</b><br>");
		out.println("<b>���ؽ�Ʈ�� : " + context + "</b><br>");
		out.println("<b>��ü��� : " + url + "</b><br>");
		out.println("<b>���θ� : " + mapping + "</b><br>");
		out.println("<b>URI : " + uri + "</b>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	
	}

}
