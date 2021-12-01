package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// advice 클래스
public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메서드 호출 전 : LogginAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 전");
		
		Object object = invocation.proceed(); // invocation을 이용해 메서드를 호출
		
		System.out.println("[메서드 호출 후 : loggingAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 후");
		return object;
	}
	
	
}
