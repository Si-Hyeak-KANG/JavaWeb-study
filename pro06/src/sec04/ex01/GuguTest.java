package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuguTest
 */
@WebServlet("/guguTest")
public class GuguTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		int dan = Integer.parseInt(request.getParameter("dan"));
		
		out.print("<table border='1' align='center'>");
		out.print("<tr align='center' bgcolor='#FFFF66'>");
		out.print("<td colspan='4'>" + dan + "단 출력 </td>");
		out.print("</tr>");
		
		for(int i = 1; i<10; i++) {
			
			if(i % 2 == 0) { 		//짝수일 경우
				out.print("<tr align='center' bgcolor='#ACFA58'>");
			} else {				//홀수일 경우
				out.print("<tr align='center' bgcolor='#81BEF7'>");
			}
			
			out.print("<td width='200'>");
			out.print("<input type='radio' />" + i);
			out.print("</td>");
			out.print("<td width='200'>");
			out.print("<input type='checkbox' />" + i);
			out.print("</td>");
			out.print("<td width='400'>");
			out.print(dan + " X " + i);
			out.print("</td>");
			out.print("<td width='400'>");
			out.print(i * dan);
			out.print("</td></tr>");
		}
		
		out.print("</table>");
	}

}
