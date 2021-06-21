package pra10.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * �� ���� API�� ���ε��� �Ӽ��� ������ �˾ƺ���
 */
@WebServlet("/pra10set")
public class SetAttribute extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String ctxMesg = "context�� ���ε��˴ϴ�.";
		String sesMesg = "session�� ���ε��˴ϴ�.";
		String reqMesg = "request�� ���ε��˴ϴ�.";
		
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		ctx.setAttribute("context", ctxMesg);
		session.setAttribute("session", sesMesg);
		request.setAttribute("request",reqMesg);
		out.print("���ε��� �����մϴ�.");
	}

}
