package com.internousdev.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.site.util.DBConnector;

public class BdeleDAO {

	private DBConnector dbc=new DBConnector();
	private Connection con=dbc.getConnection();

	// delete用　buy_itemからidで分けて削除
	public int delete(String id)throws SQLException{
		String sql="delete from buy_item where id=?";
		int result=0;

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,id);
			result=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

}
