package com.internousdev.site.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BiAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	private int count;
	private String pay;

	public String execute()throws SQLException{
		String result=SUCCESS;

		// jspから受け取ったcountの情報をsessionへ
		session.put("count",count);

		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("itemPrice").toString());
		// session-btPriceはintCount(個数)×intPrice(価格)の数字
		session.put("btPrice",intCount*intPrice);

		// 支払い方法に関する情報の確定
		String payment;
		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay",payment);
		}else{
			payment="クレジットカード";
			session.put("pay",payment);
		}
		return result;
	}

	public void setCount(int count){
		this.count=count;
	}

	public void setPay(String pay){
		this.pay=pay;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
