package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.site.dao.BuyDAO;
import com.internousdev.site.dao.LiDAO;
import com.internousdev.site.dto.ItemDTO;
import com.internousdev.site.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LiAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private Map<String,Object> session;

	private UserDTO udto=new UserDTO();
	private LiDAO lidao=new LiDAO();
	private BuyDAO bdao=new BuyDAO();
	private ArrayList<ItemDTO> buyitemList=new ArrayList<ItemDTO>();

	public String execute()throws SQLException{

		String result=ERROR;

		/* DBに一致するログインIDとパスワードがあるか確認
		 * あればログイン */
		udto=lidao.getLoginInfo(loginUserId,loginPassword);
		session.put("loginUser",udto);

		// 一致確認したユーザーにAdminFlgがあるかどうか
		if(((UserDTO)session.get("loginUser")).getAdminFlg()){

			// AdminFlgがあればsessionへ
			session.put("lu_id",udto.getLoginId());
			session.put("name",udto.getUserName());
			session.put("adflg",udto.getAdmin());

			// 購入できる商品のリスト作成
			buyitemList=bdao.getBuyitemInfo();
			Iterator<ItemDTO> iterator=buyitemList.iterator();
			if(!(iterator.hasNext())){
				buyitemList=null;
			}
			session.put("buyitemList",buyitemList);

			// 管理ページへの移動
			result="admin";

			return result;

		}else{ // AdminFlgがなければ

			session.put("lu_id",udto.getLoginId());
			session.put("name",udto.getUserName());

			// 購入できる商品のリスト作成
			buyitemList=bdao.getBuyitemInfo();
			Iterator<ItemDTO> iterator=buyitemList.iterator();
			if(!(iterator.hasNext())){
				buyitemList=null;
			}
			session.put("buyitemList",buyitemList);
			result=SUCCESS;

			return result;
		}

	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	public Map<String,Object> getSession(){
		return session;
	}
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
