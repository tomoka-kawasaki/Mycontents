package com.internousdev.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.site.util.DBConnector;

public class UdeleDAO {

	private DBConnector dbc=new DBConnector();
	private Connection con=dbc.getConnection();

	// login_userからidで分けて取り出してdelete
	public int delete(String id)throws SQLException{
		String sql="delete from login_user where id=?";
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
