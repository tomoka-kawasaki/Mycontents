package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.BdeleDAO;
import com.internousdev.site.dao.BlistDAO;
import com.internousdev.site.dto.BitemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BdeleAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private BdeleDAO bddao=new BdeleDAO();
	private ArrayList<BitemDTO> bitemList=new ArrayList<BitemDTO>();
	private BlistDAO bldao=new BlistDAO();
	private String uName;
	private String deleteFlg;
	private String message;

	BitemDTO bdto=new BitemDTO();

	/* deleteFlgがあるかないか
	 * あればdeleteへ */
	public String execute()throws SQLException{

		if(deleteFlg.equals("1")){
			delete();
		}
		return SUCCESS;
	}

	// delete用
	public void delete()throws SQLException{
		String id=session.get("id").toString();
		String uName=session.get("uName").toString();

		// buy_itemからidで分けて取り出しdelete
		int res=bddao.delete(id);
		if(res>0){
			// 削除できたとき
			setMessage("購入履歴を正しく削除しました。");
		}else if(res==0){
			// 削除できなかったとき
			setMessage("購入履歴の削除に失敗しました。");
		}
		session.put("message",message);

		/* buy_itemからusernameで分けて取り出し
		 * Listを作り直し */
		bitemList=bldao.getBInfo(uName);
		Iterator<BitemDTO> iterator=bitemList.iterator();

		if(!(iterator.hasNext())){
			bitemList=null;
		}
		session.put("bitemList",bitemList);
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public String getUName(){
		return uName;
	}
	public void setUName(String uName){
		this.uName=uName;
	}

	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}

	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}

	public ArrayList<BitemDTO> getBitemList(){
		return bitemList;
	}
	public void setBitemList(ArrayList<BitemDTO> bitemList){
		this.bitemList=bitemList;
	}

}
