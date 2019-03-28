package com.internousdev.site.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

	public String execute(){

		// session内のものをclear
		session.clear();
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
