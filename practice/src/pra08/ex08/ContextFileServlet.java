package pra08.ex08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.naming.Context;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * getServletContext() �޼���� ServletContext �����Ͽ� 
 * getResourceAsStream() �޼��忡�� �о� ���� ���� ��ġ�� ������ �� 
 * ���Ͽ��� �����͸� �Է� ����
 */
@WebServlet("/pra08cfile")
public class ContextFileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");  //�ش� ��ġ�� ������ �о� ����.
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		String menu = null;
		String menu_member = null;
		String menu_order = null;
		String menu_goods = null;
		
		while((menu=buffer.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(menu,",");
			menu_member = tokens.nextToken();
			menu_order = tokens.nextToken();
			menu_goods = tokens.nextToken();
			
		}
		
		out.println("<html><body>");
		out.println(menu_member + "<br>");
		out.println(menu_order + "<br>");
		out.println(menu_goods + "<br>");
		out.println("</body></html>");
		out.close();
	}

}
