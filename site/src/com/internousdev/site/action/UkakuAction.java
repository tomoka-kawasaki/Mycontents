package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.UkakuDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UkakuAction extends ActionSupport implements SessionAware {

	private String userId;
	private String password;
	private String name;
	private Map<String,Object> session;

	private UkakuDAO udao=new UkakuDAO();

	public String execute()throws SQLException{

		// sessionから取り出してtable-login_userへinsert
		udao.createUser(
				session.get("userId").toString(),
				session.get("password").toString(),
				session.get("name").toString());

		String result=SUCCESS;
		return result;
	}

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
