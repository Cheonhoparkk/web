package com.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.web.DBCon;
import com.web.dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO{
	@Override
	public Map<String, String> selectUserInfoById(String id) {
		Map<String,String> user = new HashMap<>();
		try(Connection con = DBCon.getConnection()){
			String sql = "SELECT * FROM USER_INFO WHERE UI_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int length = rsmd.getColumnCount();
				for(int i=1;i<=length;i++) {
					String columnName = rsmd.getColumnLabel(i);
					user.put(columnName, rs.getString(columnName));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int insertUserInfo(Map<String, String> user) {
		String sql = "INSERT INTO USER_INFO(UI_NAME, UI_ID, UI_PWD, UI_ADDR,\r\n"
				+ "UI_EMAIL)\r\n"
				+ "VALUES(?,?,?,?,?)";
		try(Connection con = DBCon.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.get("uiName"));
			pstmt.setString(2, user.get("uiId"));
			pstmt.setString(3, user.get("uiPwd"));
			pstmt.setString(4, user.get("uiAddr"));
			pstmt.setString(5, user.get("uiEmail"));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> user) {
		String sql = "UPDATE USER_INFO\r\n"
				+ "SET UI_NAME=?,\r\n"
				+ "UI_PWD=?,\r\n"
				+ "UI_ADDR=?,\r\n"
				+ "UI_EMAIL=?\r\n"
				+ "WHERE UI_NUM=?";
		try(Connection con = DBCon.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.get("uiName"));
			pstmt.setString(2, user.get("uiPwd"));
			pstmt.setString(3, user.get("uiAddr"));
			pstmt.setString(4, user.get("uiEmail"));
			pstmt.setString(5, user.get("uiNum"));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}