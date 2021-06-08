package sec04.ex01;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

// HttpSessionBindingLisetener : 세션에 바인딩/언바인딩된 객체를 알려주는 이벤트 발생 시 처리
public class LoginImpl implements HttpSessionBindingListener {

	String user_id;
	String user_pw;
	static int total_user = 0;
	
	public LoginImpl() {
		
	}
	
	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속");
		++total_user;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속 해제");
		total_user--;
	}
	
	
}
