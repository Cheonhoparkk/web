package com.web.dao;

import java.util.Map;

public interface UserInfoDAO {
	Map<String,String> selectUserInfoById(String id);
	int insertUserInfo(Map<String,String> user);
	int updateUserInfo(Map<String,String> user);
}