package com.internousdev.site.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class IsakuAction extends ActionSupport implements SessionAware {

	private String itName;
	private String itPrice;
	private String itStock;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result=SUCCESS;

		// 各項目が""(空欄)になってないか確認
		if(!(itName.equals("")) && !(itPrice.equals("")) && !(itStock.equals(""))){

			// なにかしらの入力があればsessionへ
			session.put("itName",itName);
			session.put("itPrice",itPrice);
			session.put("itStock",itStock);
		}else{

			// 空欄になっていたらerror
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
		return result;
	}

	public String getItName(){
		return itName;
	}
	public void setItName(String itName){
		this.itName=itName;
	}

	public String getItPrice(){
		return itPrice;
	}
	public void setItPrice(String itPrice){
		this.itPrice=itPrice;
	}

	public String getItStock(){
		return itStock;
	}
	public void setItStock(String itStock){
		this.itStock=itStock;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}

}
