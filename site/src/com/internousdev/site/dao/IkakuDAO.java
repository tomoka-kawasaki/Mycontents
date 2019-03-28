package com.internousdev.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.site.util.DBConnector;
import com.internousdev.site.util.DateUtil;

public class IkakuDAO {

	private DBConnector dbc=new DBConnector();
	private Connection con=dbc.getConnection();
	private DateUtil du=new DateUtil();

	// table-itemへinsert
	private String sql="insert into item(item_name,price,stock,insert_date) values(?,?,?,?)";

	public void createItem(String itName,String itPrice,String itStock)throws SQLException{

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,itName);
			ps.setString(2,itPrice);
			ps.setString(3,itStock);
			ps.setString(4,du.getDate());

			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

}
