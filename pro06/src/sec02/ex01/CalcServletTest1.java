package sec02.ex01;

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
 * Servlet implementation class CalcServletTest1
 */
@WebServlet("/calc2")
public class CalcServletTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static float USD_RATE = 1132.50f;
	private static float JPY_RATE = 1039.23f;
	private static float CNY_RATE = 175.82f;
	private static float GBP_RATE = 1599.09f;
	private static float EUR_RATE = 1380.29f;
	
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
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		String command = request.getParameter("command");
		
		if(command != null && command.equals("calculate")) {
			
			String result = calculate(Float.parseFloat(won), operator); //parseFloat은 string을 float으로 변환
			
			pw.print("<html><title>환율 계산 결과 </title>");
			pw.print("<font size=10>변환 결과</font><br>");
			pw.print("<font size=10>" + result + "</font><br>");
			pw.print("<a href='pro06/calcTest.html'>환율 계산기</a>");
			
			return;
		}
		
	}
	
	//환율 계산 메서드
	private static String calculate(float won, String operator) {
		
		String result = null;
		
		if(operator.equals("dollar")) {
			result = String.format("%.6f", won / USD_RATE);
		}else if(operator.equals("en")) {
			result = String.format("%.6f", won / JPY_RATE);
		}else if(operator.equals("wian")) {
			result = String.format("%.6f", won / CNY_RATE);
		}else if(operator.equals("pound")) {
			result = String.format("%.6", won / GBP_RATE);
		}else if(operator.equals("euro")) {
			result = String.format("%.6", won / EUR_RATE);
		}
		return result;
	}


}
