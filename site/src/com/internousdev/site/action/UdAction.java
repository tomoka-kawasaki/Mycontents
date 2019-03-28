package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.UlistDAO;
import com.internousdev.site.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UdAction extends ActionSupport implements SessionAware {

	private String id;
	private ArrayList<UserDTO> userList=new ArrayList<UserDTO>();
	private Map<String,Object> session;

	public String execute()throws SQLException{
		String result=ERROR;

		UlistDAO uldao=new UlistDAO();
		UserDTO udto=new UserDTO();

		// table-login_userからidで分けて取り出す
		udto=uldao.getUInfo(id);
		session.put("id",udto.getId());
		session.put("loginId",udto.getLoginId());
		session.put("loginPass",udto.getLoginPass());
		session.put("userName",udto.getUserName());
		session.put("insert_date",udto.getInsert_date());

		// 取り出したものに新たに番号を振る
		ArrayList<String> idList=new ArrayList<String>(Arrays.asList("1","2","3","4","5"));
		session.put("idList",idList);

		userList=uldao.getUserInfo();
		Iterator<UserDTO> iterator=userList.iterator();
		if(!(iterator.hasNext())){
			idList=null;
		}
		if(!userList.isEmpty() || idList==null){
			session.put("userList",userList);
			result=SUCCESS;
		}
		return result;
	}

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<UserDTO> getUserList(){
		return userList;
	}
	public void setUserList(ArrayList<UserDTO> userList){
		this.userList=userList;
	}

}
