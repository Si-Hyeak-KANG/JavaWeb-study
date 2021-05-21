package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginTest
 */
@WebServlet("/loginTest")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}


	public void destroy() {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + pw);
		
		if(id != null && (id.length() != 0)) { 	//아이디를 정상적으로 입력시
			
			if(id.equals("admin")) {			//admin계정으로 로그인 시
				out.print("<html>");
				out.print("<body>");
				out.print("<font size=12> 관리자로 로그인했습니다.</font>");
				out.print("<br>");
				out.print("<input type='button' value='회원 정보 수정하기' />");
				out.print("<input type='button' value='회원 삭제 수정하기' />");
				out.print("</body></html>");
			}else {								//일반 회원일 시
				out.print("<html>");
				out.print("<body>");
				out.print(id+"님 로그인 하셨습니다!!");
				out.print("</body>");
				out.print("</html>");
			}

		}
		else {									//아이디를 입력하지않고 로그인 시
			out.print("<html>");
			out.print("<body>");
			out.print("아이디를 입력하세요!");
			out.print("<br>");
			out.print("<a href='http://localhost:8091/pro06/test01/login.html'>로그인창으로 이동</a>");
			out.print("</body>");
			out.print("</html>");
			
		}
	}

}
