package pra08.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * SetServletContext 클래스 : 
 * 
 * getServletContext() 메서드를 이용해  ServletContext 객체에 접근 후 ArrayList에 이름과 나이를 저장한 후
 * 다시 ServletContext 객체에 setAttribute() 메서드를 이용해 바인딩
 */
@WebServlet("/pra08cset")
public class SetServletContext extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		List member = new ArrayList();
		member.add("이순신");
		member.add(30);
		context.setAttribute("member",member);
		
		out.println("<html><body>");
		out.println("이순신과 30 설정");
		out.println("</body></html>");
	}


}
