package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.UlistDAO;
import com.internousdev.site.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UlAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private UlistDAO uldao=new UlistDAO();
	private ArrayList<UserDTO> userList=new ArrayList<UserDTO>();

	public String execute()throws SQLException{

		// messageは消す
		session.remove("message");

		// table-login_userからすべて取り出してListを作る
		userList=uldao.getUserInfo();
		Iterator<UserDTO> iterator=userList.iterator();

		if(!(iterator.hasNext())){
			userList=null;
		}
		session.put("userList",userList);
		return SUCCESS;
	}


	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<UserDTO> getUserList(){
		return this.userList;
	}
	public void setUserList(ArrayList<UserDTO> userList){
		this.userList=userList;
	}

}
