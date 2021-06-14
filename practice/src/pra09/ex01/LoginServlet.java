package pra09.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <hidden> 태그를 이용한 세션 트래킹 실습 복습
 */
@WebServlet("/pra09login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		String email = request.getParameter("user_email");
		String hp = request.getParameter("user_hp");
		
		String data="안녕하세요!<br> 로그인하셨습니다.<br><br>";
		data += "<html><body>";
		data += "아이디 : " + id;
		data += "<br>";
		data += "비밀번호 : " + pwd;
		data += "<br>";
		data += "주소 : " + address;
		data += "<br>";
		data += "email : " + email;
		data += "<br>";
		data += "hp : " + hp;
		
		out.println(data);
		
				
	}
	
	public void destroy()
	{
		System.out.println("destroy 메서드 호출");
	}
}
