package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.UkakuDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UsakuAction extends ActionSupport implements SessionAware {

	private String userId;
	private String password;
	private String name;
	private Map<String,Object> session;
	private String errorMessage;
	private String message;
	private UkakuDAO ukdao=new UkakuDAO();

	public String execute() throws SQLException{
		String result=SUCCESS;

		// 入力されたものがすでにtable-login_userにあるものか確認
		if(ukdao.idkaku(userId)){
			setMessage("使用されているIDです。");
			result=ERROR;

		}else{
			// 未登録のものであれば入力項目が""(空欄)でないか確認
			if(!(userId.equals("")) && !(password.equals("")) && !(name.equals(""))){
				session.put("userId",userId);
				session.put("password",password);
				session.put("name",name);

			}else{
				// 空欄があればerror
				setErrorMessage("未入力の項目があります");
				result=ERROR;
			}
		}
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

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}

	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}