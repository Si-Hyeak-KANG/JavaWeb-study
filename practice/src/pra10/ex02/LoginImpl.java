package pra10.ex02;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener {

	String user_id;
	String user_pw;
	static int total_user = 0; //세션에 바인딩 시 1씩 증가시킴
	
	public LoginImpl() {
		
	}
	
	public LoginImpl(String user_id,String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {	// 세션에 저장 시 접속자수를 증가

		System.out.println("사용자 접속");
		total_user++;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) { // 세션에서 소멸 시 접속자 수를 감소

		System.out.println("사용자 접속 해제");
		total_user--;
	}
	
	
}
