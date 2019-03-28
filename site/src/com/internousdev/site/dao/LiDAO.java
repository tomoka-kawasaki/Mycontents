package com.internousdev.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.site.dto.UserDTO;
import com.internousdev.site.util.DBConnector;

public class LiDAO {

	private DBConnector dbc=new DBConnector();
	private Connection con=dbc.getConnection();
	private UserDTO udto=new UserDTO();

	// table-login_userの中のlogin_idとlogin_passに一致する物があるかどうか判定するのに使用
	public UserDTO getLoginInfo(String loginUserId,String loginPassword){

		String sql="select * from login_user where login_id=? and login_pass=?";

		try{

			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,loginUserId);
			ps.setString(2,loginPassword);

			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				udto.setLoginId(rs.getString("login_id"));
				udto.setLoginPass(rs.getString("login_pass"));
				udto.setUserName(rs.getString("user_name"));
				udto.setAdmin(rs.getString("admin_flg"));

				// もしadmin_flgのなかにaが入っていたら
				if(rs.getString("admin_flg").equals("a")){
					udto.setAdminFlg(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return udto;
	}

	public UserDTO getLidto(){
		return udto;
	}

}
