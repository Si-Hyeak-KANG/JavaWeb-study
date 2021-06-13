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
 * load-on-startup 기능 사용
 */
@WebServlet(name = "loadConfig", urlPatterns = { "/pra08loadConfig" }, loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context; // 변수 context를 멤버변수로 선언
	
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("LoadAppConfig의 init 메서드 호출");
		context = config.getServletContext(); // init() 메서드에서 ServletContext 객체를 얻음
		
		// getInitParameter() 메서드로 web.xml의 메뉴 절보를 읽어 들임.
		String menu_member = context.getInitParameter("menu_member"); 
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		// 메뉴 정보를 ServletContext 객체에 바인딩
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
		out.println("<table border=1><tr>메뉴이름</tr>");
		out.println("<tr><td>" + menuMember + "</td></tr>");
		out.println("<tr><td>" + menuOrder + "</td></tr>");
		out.println("<tr><td>" + menuGoods + "</td></tr>");
		out.println("</table></body></html>");
	}

}
