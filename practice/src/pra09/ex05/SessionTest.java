package pra09.ex05;

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
 * 세션 API 이용 
 */
@WebServlet("/pra09sess")
public class SessionTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//getSession()을 호출하여 최초 요청 시 세션 객체를 새로 생성하거나 기존 세션을 반환
		HttpSession session = request.getSession(); 
		out.println("세션 아이디 : "+ session.getId()+"<br>"); // 생성된 세션 객체의 id를 가져옴.
		
		out.println("최초 세션 생성 시각: "+ new Date(session.getCreationTime())+"<br>"); //최초 세션 객체 생성 시간을 가져옴
		out.println("최근 세션 접근 시각 : " + new Date(session.getLastAccessedTime())+"<br>"); // 세션 객체에 가장 최근에 접근한 시간을 가져옴
		out.println("세션 유효 시간 : " +session.getMaxInactiveInterval()+"<br>"); // 세션 객체의 유효 시간을 가져옴
		
		//최초 생성된 세션인지 판별
		if(session.isNew()) {
			out.println("새 세션이 만들어졌습니다.");
		}
		
	}

}
