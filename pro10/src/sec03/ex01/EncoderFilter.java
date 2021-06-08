package sec03.ex01;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
//@WebFilter("/*")
public class EncoderFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncoderFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("doFilter ȣ��");
		request.setCharacterEncoding("utf-8");
		
		String context = ((HttpServletRequest) request).getContextPath();
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		String realPath = request.getRealPath(pathinfo);
		String mesg = " Context ����:" + context + "\n URI ���� : " + pathinfo + "\n ������ ���: " + realPath;
		System.out.println(mesg);
		
		long begin = System.currentTimeMillis(); // ��û��
		chain.doFilter(request, response); // chain.dofilter �������� ���� ������ ��û ���� ���, �ϴܿ� ������ ���� ���� ���
		
		long end = System.currentTimeMillis(); // �����
		System.out.println("�۾� �ð�: " + (end - begin) + "ms"); // ������ ��û�� ������ �۾� �ð�
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
