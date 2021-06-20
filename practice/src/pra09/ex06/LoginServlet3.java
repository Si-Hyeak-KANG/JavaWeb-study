package pra09.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 데이터베이스의 저장된 회원인가,,
 * 성공시 자신의 회원 정보 조회 가능(세션 연결)
 */
@WebServlet("/pra09login3")
public class LoginServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();

		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		
		MemberVO vo = new MemberVO();
		vo.setId(user_id);
		vo.setPwd(user_pw);
		
		boolean result = dao.checkId(vo);

		if(result) {			
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("user_id", user_id);
			session.setAttribute("user_pw", user_pw);
			out.println("<html><body>");
			out.println("안녕하세요!" + user_id + "님! <br>");
			out.println("<a href='pra09view2'>회원 정보 조회</a>");
			out.println("</body></html>");
			
		}else {
			out.println("<a href='pra09login4.html'>아이디와 비밀번호가 맞지않습니다.");
		}


		
		
	}

}
