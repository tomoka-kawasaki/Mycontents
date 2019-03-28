package com.internousdev.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.site.dto.ItemDTO;
import com.internousdev.site.util.DBConnector;

public class BuyDAO {

	private DBConnector dbc=new DBConnector();
	private Connection con=dbc.getConnection();

	// table-item内の情報を取り出す
	public ArrayList<ItemDTO> getBuyitemInfo()throws SQLException{
		ArrayList<ItemDTO> itemdto=new ArrayList<ItemDTO>();

		String sql="select * from item";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				ItemDTO idto=new ItemDTO();
				idto.setId(rs.getString("id"));
				idto.setItemName(rs.getString("item_name"));
				idto.setItemPrice(rs.getString("price"));
				idto.setItemStock(rs.getString("stock"));
				itemdto.add(idto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemdto;
	}

	// table-itemからitem_nameが一致するものを取り出し
	public ItemDTO getBiInfo(String itemName)throws SQLException{
		ItemDTO dto=new ItemDTO();

		String sql="select * from item where item_name=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,itemName);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("price"));
				dto.setItemStock(rs.getString("stock"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return dto;
	}

}
