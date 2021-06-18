package pra09.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class pra09login2
 */
@WebServlet("/pra09login2")
public class pra09login2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		HttpSession session = request.getSession();
		
		//세션이 새로 생성되었는가
		if(session.isNew()) {
			if(user_id != null) {
				session.setAttribute("user_id",user_id);
				out.println("<a href='pra09login2'>로그인 상태 확인하기</a>");
			} else {
				out.println("<a href='pra09login2.html'>다시 로그인 하세요</a>");
				session.invalidate();
			}
			
		}else {
			//세션이 새로 생성되었을 때 바인딩했던 아이디 정보를 가져옴
			user_id = (String)session.getAttribute("user_id");
			
			//로그인창에서 아이디를 적고 로그인했는가
			if(user_id != null && user_id.length() != 0) {
				out.println("안녕하세요" + user_id + "님!!!");
			}else {
				out.println("<a href='pra09login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
			
		}
	}

}
