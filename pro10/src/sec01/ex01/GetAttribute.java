package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

//ServletContext, HttpSession, Request ������ Scope Ȯ��
@WebServlet("/pro10Get")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		String ctxMesg = (String) ctx.getAttribute("context");
		String sesMesg = (String) session.getAttribute("session");
		String reqMesg = (String) request.getAttribute("request");
		
		out.print("context�� : " + ctxMesg + "<br>"); //��� ���ø����̼ǿ��� ������ ������ scope -> �ٸ� ������������ ���ε� ����
		out.print("session�� : " + sesMesg + "<br>"); // ������ �������� ���ε� scope
		out.print("request�� : " + reqMesg + "<br>"); // �������� �ٸ� �� => request �� : null 
	}

}
