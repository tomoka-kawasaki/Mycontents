package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.BuyDAO;
import com.internousdev.site.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	private String itemName;
	private ArrayList<ItemDTO> buyitemList=new ArrayList<ItemDTO>();

	public String execute()throws SQLException{
		String result=ERROR;

		BuyDAO bdao=new BuyDAO();
		ItemDTO idto=new ItemDTO();

		// 商品に関することを呼び出す
		idto=bdao.getBiInfo(itemName);
		session.put("id",idto.getId());
		session.put("itemName",idto.getItemName());
		session.put("itemPrice",idto.getItemPrice());
		session.put("itemStock",idto.getItemStock());

		// 商品に関することをListに収納
		ArrayList<String> inList=new ArrayList<String>(Arrays.asList("1","2","3","4","5"));
		session.put("inList",inList);

		buyitemList=bdao.getBuyitemInfo();
		Iterator<ItemDTO> iterator=buyitemList.iterator();
		if(!(iterator.hasNext())){
			inList=null;
		}
		if(!buyitemList.isEmpty() || inList==null){
			session.put("buyitemList",buyitemList);
			result=SUCCESS;
		}

		return result;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}

	public ArrayList<ItemDTO> getBuyitemList(){
		return buyitemList;
	}
	public void setBuyitemList(ArrayList<ItemDTO> buyitemList){
		this.buyitemList=buyitemList;
	}

}
