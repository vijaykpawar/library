package library.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
private String username;
	
	private String password;
	SessionMap<String,Object> sessionmap;
	
	public String signIn(){
		try {
			
			if("admin".equals(username) && "password".equals(password)){
				return SUCCESS;
		    }  
		    else{ 
		    	addActionError("Incorrect Username or Password"); 
		    }  
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR; 
		}
		return ERROR;
	}
	
	
	public String dashboard(){
		return SUCCESS;
	}
	public void validateSignIn() {
		if (username == null || username.trim().length() <= 0) {
			addActionError(getText("Username Required"));
		}

		if (password == null || password.trim().length() <= 0) {
			addActionError(getText("Password required"));
		}
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map<String, Object> session) {
		sessionmap=(SessionMap)session;  
		sessionmap.put("login","true");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
