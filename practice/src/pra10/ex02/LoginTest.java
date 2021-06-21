package pra10.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * HttpSessionBindingListener�� �̿��� �α��� �����ڼ� ǥ��
 */
@WebServlet("/pra10login")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(user_id,user_pw); //�̺�Ʈ �ڵ鷯�� ������ �� ���ǿ� ����
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}
		
		out.println("<head>");
		out.println("<script type='text/javascript'>");
		out.println("setTimeout('history.go(0);',5000"); //�ڹٽ�ũ��Ʈ�� setTimeout()�Լ��� �̿��� 5�ʸ��� ������ ���û�Ͽ� ���� �����ڼ��� ǥ��
		out.println("</script>");
		out.println("</head>");
		out.println("<html><body>");
		out.println("���̵�� " + loginUser.user_id + "<br>");
		out.println("�� ������ ���� " + LoginImpl.total_user + "<br>");
		out.println("</body></html>");
		
	}

}
