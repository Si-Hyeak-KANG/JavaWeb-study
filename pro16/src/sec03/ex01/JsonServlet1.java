package sec03.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 * JSP . ajax ����� �̿��� ���� JSON ������ ����
 */
@WebServlet("/json")
public class JsonServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String jsonInfo = request.getParameter("jsonInfo"); // ���ڿ��� ���۵� JSON �����͸� getParameter()�� �̿��� ������
			try {
				JSONParser jsonParser = new JSONParser(); // JSON �����͸� ó���ϱ� ���� JSONParser ��ü�� ����
				JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo); // ���۵� JSON �����͸� �Ľ�
				
				System.out.println("* ȸ�� ���� *");
				
				//JSON �������� name �Ӽ����� get()�� �����Ͽ� value�� ���
				System.out.println(jsonObject.get("name"));
				System.out.println(jsonObject.get("age"));
				System.out.println(jsonObject.get("gender"));
				System.out.println(jsonObject.get("nickname"));
			} catch(Exception e) {
				e.printStackTrace();
			}
	}

}
