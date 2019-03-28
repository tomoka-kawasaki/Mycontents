package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.IlistDAO;
import com.internousdev.site.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class IdAction extends ActionSupport implements SessionAware {

	private String id;
	private ArrayList<ItemDTO> itemList=new ArrayList<ItemDTO>();
	private Map<String,Object> session;

	public String execute()throws SQLException{
		String result=ERROR;
		ItemDTO idto=new ItemDTO();
		IlistDAO ildao=new IlistDAO();

		// table-itemからidで分けて取り出す
		idto=ildao.getIInfo(id);
		session.put("id",idto.getId());
		session.put("itemName",idto.getItemName());
		session.put("itemPrice",idto.getItemPrice());
		session.put("itemStock",idto.getItemStock());
		session.put("insert_date",idto.getInsert_date());

		// 取り出してきたものに新たに番号を振る
		ArrayList<String> idList=new ArrayList<String>(Arrays.asList("1","2","3","4","5"));
		session.put("idList",idList);

		itemList=ildao.getItemInfo();
		Iterator<ItemDTO> iterator=itemList.iterator();
		if(!(iterator.hasNext())){
			idList=null;
		}
		if(!itemList.isEmpty() || idList==null){
			session.put("itemList",itemList);
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

	public ArrayList<ItemDTO> getItemList(){
		return itemList;
	}
	public void setItemList(ArrayList<ItemDTO> itemList){
		this.itemList=itemList;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
