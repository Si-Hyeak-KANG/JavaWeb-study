package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//���������� �����ϴ� Controller �������̽� ����
public class SimpleUrlController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return new ModelAndView("index.jsp"); // �۾��� ��ģ �� ���̸��� ModelAndView�� index.jsp�� ���� �� ��ȯ
	}

}
