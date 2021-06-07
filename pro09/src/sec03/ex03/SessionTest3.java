package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest3
 */
@WebServlet("/sess3")
public class SessionTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		out.println("세션 아이디: " + session.getId() + "<br>");
		out.println("최초 세션 생성 시각: " + new Date(session.getCreationTime()) + "<br>");
		out.println("최근 세션 접근 시각: " + new Date(session.getLastAccessedTime()) + "<br>");
		out.println("세션 유효 시간: " + session.getMaxInactiveInterval() + "<br>");
		if (session.isNew()) {
			out.print("새 세션이 만들어졌습니다.");
		}
		session.invalidate();  //기존에 생성된 세션 객체를 강제로 제거
		
	}

}
