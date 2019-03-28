package com.internousdev.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.site.dto.BitemDTO;
import com.internousdev.site.util.DBConnector;

public class BlistDAO {

	private DBConnector dbc=new DBConnector();
	private Connection con=dbc.getConnection();

	// buy_itemからusernameで分けて取り出す用
	public ArrayList<BitemDTO> getBInfo(String uName)throws SQLException{
		ArrayList<BitemDTO> idto=new ArrayList<BitemDTO>();

		String sql="select * from buy_item where username=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,uName);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				BitemDTO dto=new BitemDTO();
				dto.setId(rs.getString("id"));
				dto.setItemId(rs.getString("item_id"));
				dto.setToPrice(rs.getString("total_price"));
				dto.setToCount(rs.getString("total_count"));
				dto.setUName(rs.getString("username"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsertdate(rs.getString("insert_date"));
				idto.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return idto;
	}

	// buy_itemからidで分けて取り出す用
	public BitemDTO getBuyIInfo(String id)throws SQLException{
		BitemDTO bidto=new BitemDTO();

		String sql="select * from buy_item where id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				bidto.setId(rs.getString("id"));
				bidto.setItemId(rs.getString("item_id"));
				bidto.setToPrice(rs.getString("total_price"));
				bidto.setToCount(rs.getString("total_count"));
				bidto.setUName(rs.getString("username"));
				bidto.setPayment(rs.getString("pay"));
				bidto.setInsertdate(rs.getString("insert_date"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return bidto;
	}

}
