package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.BlistDAO;
import com.internousdev.site.dto.BitemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BryoAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private String uName;
	private BlistDAO bldao=new BlistDAO();
	private ArrayList<BitemDTO> bitemList=new ArrayList<BitemDTO>();

	public String execute()throws SQLException{

		String uName=session.get("lu_id").toString();

		// buy_itemからuser_nameで分けて取り出しListを作る
		bitemList=bldao.getBInfo(uName);
		Iterator<BitemDTO> iterator=bitemList.iterator();

		if(!(iterator.hasNext())){
			bitemList=null;
		}
		session.put("bitemList",bitemList);

		// messageは消す
		session.remove("message");
		return SUCCESS;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<BitemDTO> getBitemList(){
		return this.bitemList;
	}
	public void setBitemList(ArrayList<BitemDTO> bitemList){
		this.bitemList=bitemList;
	}

	public String getUName(){
		return uName;
	}
	public void setUName(String uName){
		this.uName=uName;
	}

}
