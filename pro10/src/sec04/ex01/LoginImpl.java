package sec04.ex01;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

// HttpSessionBindingLisetener : ���ǿ� ���ε�/����ε��� ��ü�� �˷��ִ� �̺�Ʈ �߻� �� ó��
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
		System.out.println("����� ����");
		++total_user;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("����� ���� ����");
		total_user--;
	}
	
	
}
