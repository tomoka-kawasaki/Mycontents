package com.internousdev.site.dto;

public class UserDTO {

	private String id;
	private String loginId;
	private String loginPass;
	private String userName;
	private String admin;
	private String insert_date;
	private boolean loginFlg=false;
	private boolean adminFlg=false;

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}

	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}

	public String getLoginPass(){
		return loginPass;
	}
	public void setLoginPass(String loginPass){
		this.loginPass=loginPass;
	}

	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}

	public String getAdmin(){
		return admin;
	}
	public void setAdmin(String admin){
		this.admin=admin;
	}

	public String getInsert_date(){
		return insert_date;
	}
	public void setInsert_date(String insert_date){
		this.insert_date=insert_date;
	}

	public boolean getLoginFlg(){
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg){
		this.loginFlg=loginFlg;
	}

	public boolean getAdminFlg(){
		return adminFlg;
	}
	public void setAdminFlg(boolean adminFlg){
		this.adminFlg=adminFlg;
	}

}
