package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.IlistDAO;
import com.internousdev.site.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class IlAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private IlistDAO ildao=new IlistDAO();
	private ArrayList<ItemDTO> itemList=new ArrayList<ItemDTO>();

	public String execute()throws SQLException{

		// messageは消す
		session.remove("message");

		// table-itemから取り出してListを作る
		itemList=ildao.getItemInfo();
		Iterator<ItemDTO> iterator=itemList.iterator();

		if(!(iterator.hasNext())){
			itemList=null;
		}
		session.put("itemList",itemList);
		return SUCCESS;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<ItemDTO> getItemList(){
		return itemList;
	}
	public void setItemList(ArrayList<ItemDTO> itemList){
		this.itemList=itemList;
	}

}
