package pra10.ex02;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener {

	String user_id;
	String user_pw;
	static int total_user = 0; //���ǿ� ���ε� �� 1�� ������Ŵ
	
	public LoginImpl() {
		
	}
	
	public LoginImpl(String user_id,String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {	// ���ǿ� ���� �� �����ڼ��� ����

		System.out.println("����� ����");
		total_user++;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) { // ���ǿ��� �Ҹ� �� ������ ���� ����

		System.out.println("����� ���� ����");
		total_user--;
	}
	
	
}
