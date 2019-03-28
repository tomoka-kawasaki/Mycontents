package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.BlistDAO;
import com.internousdev.site.dto.BitemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BdAction extends ActionSupport implements SessionAware {

	private String id;
	private String uName;
	private ArrayList<BitemDTO> bitemList=new ArrayList<BitemDTO>();
	private Map<String,Object> session;

	public String execute()throws SQLException{
		String result=ERROR;
		BlistDAO bldao=new BlistDAO();
		BitemDTO bdto=new BitemDTO();

		// buy_itemからidで分けて取り出す
		bdto=bldao.getBuyIInfo(id);

		session.put("id",bdto.getId());
		session.put("itemId",bdto.getItemId());
		session.put("toPrice",bdto.getToPrice());
		session.put("toCount",bdto.getToCount());
		session.put("uName",bdto.getUName());
		session.put("payment",bdto.getPayment());
		session.put("insertdate",bdto.getInsertdate());

		// List作成
		ArrayList<String> idList=new ArrayList<String>(Arrays.asList("1","2","3","4","5"));
		session.put("idList",idList);

		bitemList=bldao.getBInfo(uName);
		Iterator<BitemDTO> iterator=bitemList.iterator();
		if(!(iterator.hasNext())){
			idList=null;
		}
		if(!bitemList.isEmpty() || idList==null){
			session.put("bitemList",bitemList);
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

	public String getUName(){
		return uName;
	}
	public void setUName(String uName){
		this.uName=uName;
	}

	public ArrayList<BitemDTO> getBitemList(){
		return bitemList;
	}
	public void setBitemList(ArrayList<BitemDTO> bitemList){
		this.bitemList=bitemList;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
