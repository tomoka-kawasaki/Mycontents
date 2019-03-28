package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.UdeleDAO;
import com.internousdev.site.dao.UlistDAO;
import com.internousdev.site.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UdeleAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private UdeleDAO uddao=new UdeleDAO();
	private ArrayList<UserDTO> userList=new ArrayList<UserDTO>();
	private UlistDAO uldao=new UlistDAO();
	private String deleteFlg;
	private String message;

	UserDTO udto=new UserDTO();

	public String execute()throws SQLException{

		// deleteFlgが1かどうか
		if(deleteFlg.equals("1")){
			delete();
		}
		return SUCCESS;
	}

	// delete用
	public void delete()throws SQLException{
		String id=session.get("id").toString();

		// table-login_userからidで取り出してdelete
		int res=uddao.delete(id);
		if(res>0){
			setMessage("ユーザー情報を正しく削除しました。");
		}else if(res==0){
			setMessage("ユーザー情報の削除に失敗しました。");
		}
		session.put("message",message);

		// table-login_userから改めてすべて取り出してListにする
		userList=uldao.getUserInfo();
		Iterator<UserDTO> iterator=userList.iterator();

		if(!(iterator.hasNext())){
			userList=null;
		}
		session.put("userList",userList);
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}

	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}

	public ArrayList<UserDTO> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserDTO> userList) {
		this.userList = userList;
	}


}
