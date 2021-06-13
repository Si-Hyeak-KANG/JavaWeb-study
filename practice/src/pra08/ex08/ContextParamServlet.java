package pra08.ex08;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * web.xml에 설정해둔 내용을 사용하는 기능
 */
@WebServlet("/pra08InitMenu")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		String menuMember = context.getInitParameter("menu_member");
		String menuOrder = context.getInitParameter("menu_order");
		String menuGoods = context.getInitParameter("menu_goods");
		
		out.println("<html><body>");
		out.println("<table border='1' cellspacing=0><tr>메뉴 이름</tr>");
		out.println("<tr><td>" + menuMember + "</td></tr>");
		out.println("<tr><td>" + menuOrder + "</td></tr>");
		out.println("<tr><td>" + menuGoods + "</td></tr>");
		out.println("</table></body></html>");
	}

}
