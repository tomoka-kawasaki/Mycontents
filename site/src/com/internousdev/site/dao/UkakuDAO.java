package com.internousdev.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.site.dto.UserDTO;
import com.internousdev.site.util.DBConnector;
import com.internousdev.site.util.DateUtil;

public class UkakuDAO {

	private DBConnector dbc=new DBConnector();
	private Connection con=dbc.getConnection();
	private DateUtil du=new DateUtil();

	// login_userへinsert
	public void createUser(String userId,String password,String name)throws SQLException{

		String sql="insert into login_user(login_id,login_pass,user_name,insert_date) values(?,?,?,?)";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2,password);
			ps.setString(3,name);
			ps.setString(4,du.getDate());

			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

	// login_userからlogin_idで取り出して確認
	public boolean idkaku(String userId) throws SQLException{
		UserDTO dto=new UserDTO();
		boolean result=false;

		String sql="select * from login_user where login_id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userId);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				result=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

}
