package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// advice Ŭ����
public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[�޼��� ȣ�� �� : LogginAdvice");
		System.out.println(invocation.getMethod() + "�޼��� ȣ�� ��");
		
		Object object = invocation.proceed(); // invocation�� �̿��� �޼��带 ȣ��
		
		System.out.println("[�޼��� ȣ�� �� : loggingAdvice");
		System.out.println(invocation.getMethod() + "�޼��� ȣ�� ��");
		return object;
	}
	
	
}
