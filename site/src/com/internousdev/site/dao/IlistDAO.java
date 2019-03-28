package com.internousdev.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.site.dto.ItemDTO;
import com.internousdev.site.util.DBConnector;

public class IlistDAO {

	private DBConnector dbc=new DBConnector();
	private Connection con=dbc.getConnection();

	// itemから登録されているものすべてを取り出す
	public ArrayList<ItemDTO> getItemInfo()throws SQLException{
		ArrayList<ItemDTO> idto=new ArrayList<ItemDTO>();
		String sql="select * from item";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				ItemDTO dto=new ItemDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("price"));
				dto.setItemStock(rs.getString("stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				idto.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return idto;
	}

	// itemからidで分けて取り出す
	public ItemDTO getIInfo(String id)throws SQLException{
		ItemDTO itdto=new ItemDTO();

		String sql="select * from item where id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				itdto.setId(rs.getString("id"));
				itdto.setItemName(rs.getString("item_name"));
				itdto.setItemPrice(rs.getString("price"));
				itdto.setItemStock(rs.getString("stock"));
				itdto.setInsert_date(rs.getString("insert_date"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itdto;
	}

}
