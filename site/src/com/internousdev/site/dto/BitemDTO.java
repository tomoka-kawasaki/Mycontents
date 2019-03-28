package com.internousdev.site.dto;

public class BitemDTO {

	private String id;
	private String itemId;
	private String toPrice;
	private String toCount;
	private String uName;
	private String payment;
	private String insertdate;

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}

	public String getItemId(){
		return itemId;
	}
	public void setItemId(String itemId){
		this.itemId=itemId;
	}

	public String getToPrice(){
		return toPrice;
	}
	public void setToPrice(String toPrice){
		this.toPrice=toPrice;
	}

	public String getToCount(){
		return toCount;
	}
	public void setToCount(String toCount){
		this.toCount=toCount;
	}

	public String getUName(){
		return uName;
	}
	public void setUName(String uName){
		this.uName=uName;
	}

	public String getPayment(){
		return payment;
	}
	public void setPayment(String payment){
		this.payment=payment;
	}

	public String getInsertdate(){
		return insertdate;
	}
	public void setInsertdate(String insertdate){
		this.insertdate=insertdate;
	}

}
