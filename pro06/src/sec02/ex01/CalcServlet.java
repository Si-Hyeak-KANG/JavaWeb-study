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
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
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
		
		String command = request.getParameter("command"); //수행할 요청
		String won = request.getParameter("won"); // 변환할 원화
		String operator = request.getParameter("operator"); //변환할 외화 종류
		
		if(command != null && command.equals("calculate")) {
			
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><font size=10>변환결과</font><br>");
			pw.print("<font size=10>" + result + "</font><br>");
			pw.print("<a href='pro06/calc'>돌아가기</a>");
			return;
		}
		
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size=5>환율 계산기</font>");
		pw.print("<form name='frmCalc' method='get' action='/pro06/calc' /> ");
		pw.print("원화: <input type='text' name='won' size=10 />" );
		pw.print("<select name='operator'>");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='wian'>위안</option>");
		pw.print("<option value='pound'>파운드</pound>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate'/>");
		pw.print("<input type='submit' value'변환'/>");
		pw.print("</form>");
		pw.print("</html>");
		pw.close();
	}

	private String calculate(float won, String operator) {
		
		String result=null;
		
		if(operator.equals("dollar")) {
			result = String.format("%.6f", won / USD_RATE);
		} else if(operator.equals("en")) {
			result = String.format("%.6f", won / JPY_RATE);
		} else if(operator.equals("wian")) {
			result = String.format("%.6f", won / CNY_RATE);
		} else if(operator.equals("pound")) {
			result = String.format("%.6f", won / GBP_RATE);
		} else if(operator.equals("euro")) {
			result = String.format("%.6f", won / EUR_RATE);
		}
		
		return result;
	}

}
