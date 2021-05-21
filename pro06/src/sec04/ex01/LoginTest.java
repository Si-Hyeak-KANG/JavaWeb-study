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
		
		System.out.println("���̵�: " + id);
		System.out.println("��й�ȣ: " + pw);
		
		if(id != null && (id.length() != 0)) { 	//���̵� ���������� �Է½�
			
			if(id.equals("admin")) {			//admin�������� �α��� ��
				out.print("<html>");
				out.print("<body>");
				out.print("<font size=12> �����ڷ� �α����߽��ϴ�.</font>");
				out.print("<br>");
				out.print("<input type='button' value='ȸ�� ���� �����ϱ�' />");
				out.print("<input type='button' value='ȸ�� ���� �����ϱ�' />");
				out.print("</body></html>");
			}else {								//�Ϲ� ȸ���� ��
				out.print("<html>");
				out.print("<body>");
				out.print(id+"�� �α��� �ϼ̽��ϴ�!!");
				out.print("</body>");
				out.print("</html>");
			}

		}
		else {									//���̵� �Է������ʰ� �α��� ��
			out.print("<html>");
			out.print("<body>");
			out.print("���̵� �Է��ϼ���!");
			out.print("<br>");
			out.print("<a href='http://localhost:8091/pro06/test01/login.html'>�α���â���� �̵�</a>");
			out.print("</body>");
			out.print("</html>");
			
		}
	}

}
