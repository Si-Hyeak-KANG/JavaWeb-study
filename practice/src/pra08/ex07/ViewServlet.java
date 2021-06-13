package pra08.ex07;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/pra08View")
public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List member = (List) request.getAttribute("member");
		
		
		out.println("<html><body>");
		out.println("<table border='1'>");
		out.println("<tr  align='center' bgcolor='lightgreen'><td>id</td><td>pwd</td><td>name</td><td>email</td><td>joinDate</td></tr>");
		
		for(int i=0; i<member.size(); i++) {
			
			MemberVO vo = (MemberVO)member.get(i);
			
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			Date joinDate = vo.getJoinDate();
			
			out.println("<tr>");
			out.println("<td>"+id+"</td>");
			out.println("<td>"+pwd+"</td>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+email+"</td>");
			out.println("<td>"+joinDate+"</td>");
			out.println("</tr>");
			
		}
		
		out.println("</table></body></html>");	
	}



}
