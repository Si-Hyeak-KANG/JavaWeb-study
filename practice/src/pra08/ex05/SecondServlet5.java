package pra08.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet5
 */
@WebServlet("/pra08Second5")
public class SecondServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String address = (String)request.getAttribute("address");
		//���޵� request���� getAttribute()�� �̿��� address�� ���� ������.
		
		out.println("<html><body>");
		out.println("�ּ� : " + address); //null ���
		out.println("<br>");
		out.println("redirect�� �̿��� ���ε� �ǽ�");
		out.println("</body></html>");
		
		
	}

}
