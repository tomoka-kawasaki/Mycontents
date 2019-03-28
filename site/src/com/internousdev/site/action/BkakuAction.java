package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.BkakuDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BkakuAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	private BkakuDAO bkdao=new BkakuDAO();

	public String execute()throws SQLException{

		// sessionから取り出してinsertする
		bkdao.buyiInfo(
				session.get("itemName").toString(),
				session.get("btPrice").toString(),
				session.get("count").toString(),
				session.get("lu_id").toString(),
				session.get("pay").toString());

		String result=SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
