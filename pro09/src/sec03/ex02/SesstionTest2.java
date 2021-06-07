package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SesstionTest2
 */
@WebServlet("/sess2")
public class SesstionTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		out.println("세션 아이디 : " + session.getId() + "<br>");
		out.println("최초 세션 생성 시각 : " + new Date(session.getCreationTime()) + "<br>");
		out.println("최초 세션 접근 시각 : " + new Date(session.getLastAccessedTime()) + "<br>");
		
		out.println("기본 세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		session.setMaxInactiveInterval(5); //세션 유효시간을 5초로 설정
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		
		if( session.isNew()) {
			out.print("새 세션이 만들어졌습니다.");
		}
	}

}
