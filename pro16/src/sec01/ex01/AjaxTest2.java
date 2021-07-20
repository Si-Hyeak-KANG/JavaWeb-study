package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * XML 데이터 연동
 */
@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charaset=utf-8");
		
		String result="";
		
		PrintWriter writer = response.getWriter();
		
		// 정보를 XML로 작성한 후 클라이언트로 전송
		result="<main><book>"+
				  "<title><![CDATA[초보자를 위한 자바 프로그래밍]]></title>"+
				  "<writer><![CDATA[인포북스 저자 띠리리]]></writer>" +
				  "<image><![CDATA[http://localhost:8091/pro16/image/duke2.png]]></image>"+
				"</book>"+
				"<book>"+
				  "<title><![CDATA[모두의 파이썬]]></title>"+
				  "<writer><![CDATA[길벗 저자 또로로]]></writer>"+
				  "<image><![CDATA[http://localhost:8091/pro16/image/duke.png]]></image>" +
				"</book></main>";
		
		System.out.println(result);
		writer.print(result);
		
	}
}
