package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.BuyDAO;
import com.internousdev.site.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class FirstAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private BuyDAO bdao=new BuyDAO();
	private ArrayList<ItemDTO> buyitemList=new ArrayList<ItemDTO>();

	public String execute()throws SQLException{

		// 何もなければloginへ
		String result="login";

		// sessionにlu_idがあれば
		if(session.containsKey("lu_id")){

			// 購入できる商品のリスト作成
			buyitemList=bdao.getBuyitemInfo();
			Iterator<ItemDTO> iterator=buyitemList.iterator();
			if(!(iterator.hasNext())){
				buyitemList=null;
			}
			session.put("buyitemList",buyitemList);

			result=SUCCESS;
		}
		return result;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<ItemDTO> getBuyitemList(){
		return buyitemList;
	}
	public void setBuyitemList(ArrayList<ItemDTO> buyitemList){
		this.buyitemList=buyitemList;
	}

}
