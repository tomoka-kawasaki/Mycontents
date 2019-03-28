package com.internousdev.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.site.dto.UserDTO;
import com.internousdev.site.util.DBConnector;

public class UlistDAO {

	private DBConnector dbc=new DBConnector();
	private Connection con=dbc.getConnection();

	// login_userからすべて取り出す
	public ArrayList<UserDTO> getUserInfo()throws SQLException{
		ArrayList<UserDTO> udto=new ArrayList<UserDTO>();
		String sql="select * from login_user";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				UserDTO dto=new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				udto.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return udto;
	}

	// login_userからidで分けて取り出す
	public UserDTO getUInfo(String id) throws SQLException{
		UserDTO udto=new UserDTO();

		String sql="select * from login_user where id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				udto.setId(rs.getString("id"));
				udto.setLoginId(rs.getString("login_id"));
				udto.setLoginPass(rs.getString("login_pass"));
				udto.setUserName(rs.getString("user_name"));
				udto.setInsert_date(rs.getString("insert_date"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
				con.close();
		}
		return udto;
	}

}
