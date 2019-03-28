package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.IkakuDAO;
import com.opensymphony.xwork2.ActionSupport;

public class IkakuAction extends ActionSupport implements SessionAware {

	private String itName;
	private String itPrice;
	private String itStock;
	public Map<String,Object> session;

	private IkakuDAO idao=new IkakuDAO();

	public String execute()throws SQLException{

		// sessionから取り出したものをtable-itemへinsert
		idao.createItem(
				session.get("itName").toString(),
				session.get("itPrice").toString(),
				session.get("itStock").toString());

		String result=SUCCESS;
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
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
