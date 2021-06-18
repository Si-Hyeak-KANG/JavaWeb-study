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
 *  encodeURL() 메서드를 이용한 세션 실습
 */
@WebServlet("/pra09sess4")
public class SessionTest4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		
		
		if(session.isNew()) {
		
			if(user_id != null && user_id.length() != 0) {
				session.setAttribute("user_id",user_id);
				String url = response.encodeURL("pra09sess4");
				out.println("<a href='"+url+"'>로그인 상태 확인하기</a>"); //로그인 상태 확인 클릭 시 jsessionId를 서블릿으로 다시 전송
			}else {
				out.println("<a href='pra09login3.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}else {
			
			user_id = (String)session.getAttribute("user_id");
			if(user_id != null && user_id.length() != 0) {
				out.println("안녕하세요!!" + user_id + "님!!");
			}
			else {
				out.println("<a href='pra09login3.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}
	}

}
