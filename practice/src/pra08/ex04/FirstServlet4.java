package pra08.ex04;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * dispatch를 이용한 포워드
 * 
 * 클라이언트의 웹 브라우저를 거치지 않고 바로 서버에서 포워딩
 */
@WebServlet("/pra08First4")
public class FirstServlet4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("pra08Second4?name=lee");
		dispatch.forward(request,response);
	}

}
