package com.internousdev.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.site.util.DBConnector;
import com.internousdev.site.util.DateUtil;

public class BkakuDAO {

	private DBConnector dbc=new DBConnector();
	private Connection con=dbc.getConnection();
	private DateUtil du=new DateUtil();

	private String sql="insert into buy_item(item_id,total_price,total_count,username,pay,insert_date) values(?,?,?,?,?,?)";

	// BkakuActionの購入品をtable-buy_itemにinsertする
	public void buyiInfo(String itemName,String btPrice,String count,String lu_id,String pay)throws SQLException{

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,itemName);
			ps.setString(2,btPrice);
			ps.setString(3,count);
			ps.setString(4,lu_id);
			ps.setString(5,pay);
			ps.setString(6,du.getDate());
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

}
