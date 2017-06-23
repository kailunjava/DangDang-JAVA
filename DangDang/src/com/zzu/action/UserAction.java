package com.zzu.action;


import java.util.Map;
import com.google.code.kaptcha.Constants;
import com.opensymphony.xwork2.ActionContext;

import com.zzu.entity.User;
import com.zzu.service.UserService;
import com.zzu.service.impl.UserServiceImpl;
import com.zzu.util.RandomSaltUtil;

public class UserAction {
	private String uri;//根据是否传来uri值判断不同登录时的情况
    private User user;//获得user
    private String confirmpwd;//获得确认的密码
    private String kaptcha;//获得验证码
    private String code;//获得邮箱验证码
    private UserService service = new UserServiceImpl();
    public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getUri() {
		return uri;
	}


	public void setUri(String uri) {
		this.uri = uri;
	}


	public String getConfirmpwd() {
		return confirmpwd;
	}


	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}


	public String getKaptcha() {
		return kaptcha;
	}


	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
	}

   public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


    /**
    * 
    * 用户注册的action
    */
	public String register(){
    	try {
    		//创建session作用域
    		ActionContext.getContext().getValueStack().setValue("#session.email",user.getEmail() );
    		@SuppressWarnings("unchecked")
			Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");
			//获取真正的验证码
			Object realKap = session.get(Constants.KAPTCHA_SESSION_KEY);    			     
			//判断用户输入的验证码和真正的验证码是否一致
			if(!realKap.equals(kaptcha)){
				throw new RuntimeException("验证码不正确");
			}			
			//调用service的方法进行注册用户
			service.regist(user.getEmail(), user.getNickname(), user.getPassword(), confirmpwd);						
		} catch (Exception e) {			
			e.printStackTrace();
			return "no";
		}
    	return "yes";
    }
	/**
	 * 用户登录的action
	 */
	public String login(){
    	//调用service判断用户输入是否正确
    	try {    				
			if( user.getEmail() != null && user.getPassword() != null){
				
				service.login(user.getEmail(), user.getPassword());
				User user1 = service.query(user.getEmail());
				ActionContext.getContext().getValueStack().setValue("#session.user",user1 );
				if(uri == null || uri.length() == 0){
					
					return "yes";
				}else{					
					return "order";
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "no";
		}
		return "no";    	
    }
	/**
	 * 验证邮箱验证码的action
	 */
	public String emailCode(){
		try {
			String emailCode = (String) ActionContext.getContext().getValueStack().findValue("#session.emailCode" );
			if(!emailCode.equals(code)){
				throw new RuntimeException("验证码不正确");
			}
			
			service.update( user.getEmail());
		} catch (Exception e) {
			
			e.printStackTrace();
			return "no";
		}
		return "yes";
	}
	/**
	 * 生成邮箱验证码的action
	 */
	public String code(){
		String emailCode = RandomSaltUtil.generetRandomSaltCode();
		ActionContext.getContext().getValueStack().setValue("#session.emailCode",emailCode );
		return "yes";
	}

	/**
	 * 保存注册用户的信息
	 */
    public String session(){
    	
    	String email = (String) ActionContext.getContext().getValueStack().findValue("#session.email");
		User user1 = service.query(email);
		ActionContext.getContext().getValueStack().setValue("#session.user",user1 );

    	return "yes";
    }
    /**
     * 销毁用户session
     */
    public String remove(){
    	
    	try {
			ActionContext.getContext().getSession().clear();
		} catch (Exception e) {
			
			e.printStackTrace();
			return "no";
		}
    	return "yes";
    }
}
