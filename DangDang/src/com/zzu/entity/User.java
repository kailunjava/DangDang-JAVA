package com.zzu.entity;


/**
 * 用户的实体
 * @author Administrator
 *
 */
public class User {
     private Integer id;              //用户id
     private String email;            //用户邮箱
     private String nickname;         //用户昵称
     private String password;         //用户密码
     
     private String is_email_verify; //֤邮箱是否验证
     private Integer user_integral;   //用户积分
     private String last_login_time;   //最后登录时间
     private String last_login_ip;    //最后登录ip
     public User(){}
	public User(Integer id, String email, String nickname, String password,
			String is_email_verify,Integer user_integral,
			 String last_login_time, String last_login_ip) {
		super();
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.user_integral = user_integral;
		this.is_email_verify = is_email_verify;
		
		this.last_login_time = last_login_time;
		this.last_login_ip = last_login_ip;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUser_integral() {
		return user_integral;
	}
	public void setUser_integral(Integer user_integral) {
		this.user_integral = user_integral;
	}
    
	public String getIs_email_verify() {
		return is_email_verify;
	}
	public void setIs_email_verify(String is_email_verify) {
		this.is_email_verify = is_email_verify;
	}

	public String getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(String last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getLast_login_ip() {
		return last_login_ip;
	}
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nickname=" + nickname
				+ ", password=" + password + ", user_integral=" + user_integral
				+ ", is_email_verify=" + is_email_verify
				+ ", email_verify_code=" 
				+ ", last_login_time=" + last_login_time + ", last_login_ip="
				+ last_login_ip + "]";
	}
     
}
