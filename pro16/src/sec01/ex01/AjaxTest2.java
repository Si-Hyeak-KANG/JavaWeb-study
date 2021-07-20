package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * XML ������ ����
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
		
		// ������ XML�� �ۼ��� �� Ŭ���̾�Ʈ�� ����
		result="<main><book>"+
				  "<title><![CDATA[�ʺ��ڸ� ���� �ڹ� ���α׷���]]></title>"+
				  "<writer><![CDATA[�����Ͻ� ���� �츮��]]></writer>" +
				  "<image><![CDATA[http://localhost:8091/pro16/image/duke2.png]]></image>"+
				"</book>"+
				"<book>"+
				  "<title><![CDATA[����� ���̽�]]></title>"+
				  "<writer><![CDATA[��� ���� �Ƿη�]]></writer>"+
				  "<image><![CDATA[http://localhost:8091/pro16/image/duke.png]]></image>" +
				"</book></main>";
		
		System.out.println(result);
		writer.print(result);
		
	}
}
