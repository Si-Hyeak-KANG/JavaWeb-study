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
 * JSP . ajax 기능을 이용한 서블릿 JSON 데이터 전송
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
		
		String jsonInfo = request.getParameter("jsonInfo"); // 문자열로 전송된 JSON 데이터를 getParameter()를 이용해 가져옴
			try {
				JSONParser jsonParser = new JSONParser(); // JSON 데이터를 처리하기 위해 JSONParser 객체를 생성
				JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo); // 전송된 JSON 데이터를 파싱
				
				System.out.println("* 회원 정보 *");
				
				//JSON 데이터의 name 속성들을 get()에 전달하여 value를 출력
				System.out.println(jsonObject.get("name"));
				System.out.println(jsonObject.get("age"));
				System.out.println(jsonObject.get("gender"));
				System.out.println(jsonObject.get("nickname"));
			} catch(Exception e) {
				e.printStackTrace();
			}
	}

}
