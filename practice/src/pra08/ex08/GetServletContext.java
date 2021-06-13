package pra08.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *GetServletContext 클래스 : 
 *
 * getServletContext() 메서드를 이용해 ServletContext 객체에 접근 
 * 그리고 getAttribute() 메서드를 이용해 다른 서블릿에서 바인딩한 ArrayList를 가져와 출력
 *
 */
@WebServlet("/pra08cget")
public class GetServletContext extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		List member = (List)context.getAttribute("member");

		String name = (String)member.get(0);
		int age = (int)member.get(1);
		
		out.println("<html><body>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 :" + age + "<br>");
		out.println("</body></html>");
		
	}
}
