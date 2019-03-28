package com.internousdev.site.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class IsAction extends ActionSupport {

	public Map<String,Object> session;

	public String execute(){

		// 成功したら移動
		return SUCCESS;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
