package sec04.ex02;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@WebListener
public class LoginImpl implements HttpSessionListener {

    String user_id;
    String user_pw;
    static int total_user=0;
	
    public LoginImpl() {
    	
    }
    
    public LoginImpl(String user_id,String user_pw) {
    	this.user_id = user_id;
    	this.user_pw = user_pw;
    }

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("技记 积己");
		total_user++;
	}
	

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("技记 家戈");
		--total_user;
		
	}
	
    
}
