package pra08.ex10;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * load-on-startup ��� ���
 */
@WebServlet(name = "loadConfig", urlPatterns = { "/pra08loadConfig" }, loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context; // ���� context�� ��������� ����
	
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("LoadAppConfig�� init �޼��� ȣ��");
		context = config.getServletContext(); // init() �޼��忡�� ServletContext ��ü�� ����
		
		// getInitParameter() �޼���� web.xml�� �޴� ������ �о� ����.
		String menu_member = context.getInitParameter("menu_member"); 
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		// �޴� ������ ServletContext ��ü�� ���ε�
		context.setAttribute("menu_member", menu_member);
		context.setAttribute("menu_order", menu_order);
		context.setAttribute("menu_goods",menu_goods);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String menuMember = (String) context.getAttribute("menu_member");
		String menuOrder = (String) context.getAttribute("menu_order");
		String menuGoods = (String) context.getAttribute("menu_goods");
		
		out.println("<html><body>");
		out.println("<table border=1><tr>�޴��̸�</tr>");
		out.println("<tr><td>" + menuMember + "</td></tr>");
		out.println("<tr><td>" + menuOrder + "</td></tr>");
		out.println("<tr><td>" + menuGoods + "</td></tr>");
		out.println("</table></body></html>");
	}

}
