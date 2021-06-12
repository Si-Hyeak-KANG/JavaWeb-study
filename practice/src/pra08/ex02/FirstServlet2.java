package pra08.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * refresh�� �̿��� ������ �ǽ�
 */
@WebServlet("/pra08First2")
public class FirstServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		response.addHeader("Refresh","1;url=pra08Second2"); //�� �������� 1�� �� ���� second�� ���û
	}

}
