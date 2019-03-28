package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.IdeleDAO;
import com.internousdev.site.dao.IlistDAO;
import com.internousdev.site.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class IdeleAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private IdeleDAO iddao=new IdeleDAO();
	private ArrayList<ItemDTO> itemList=new ArrayList<ItemDTO>();
	private IlistDAO ildao=new IlistDAO();
	private String deleteFlg;
	private String message;

	ItemDTO idto=new ItemDTO();

	// deleteFlgが1であるかどうか
	public String execute()throws SQLException{

		if(deleteFlg.equals("1")){
			delete();
		}
		return SUCCESS;
	}

	// delete用
	public void delete()throws SQLException{
		String id=session.get("id").toString();

		// table-itemからidで取り出してdelete
		int res=iddao.delete(id);
		if(res>0){
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
		session.put("message",message);

		// table-itemからすべて取り出してListを作り直す
		itemList=ildao.getItemInfo();
		Iterator<ItemDTO> iterator=itemList.iterator();

		if(!(iterator.hasNext())){
			itemList=null;
		}
		session.put("itemList",itemList);
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

	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}

	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}

}
