package com.web.service.impl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.web.dao.UserInfoDAO;
import com.web.dao.impl.UserInfoDAOImpl;
import com.web.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDAO uiDAO = new UserInfoDAOImpl();
	@Override
	public boolean login(String id, String pwd, HttpSession session) {
		Map<String,String> user = uiDAO.selectUserInfoById(id);
		if(!user.isEmpty()) {
			session.setAttribute("user", user);
		}
		return pwd.equals(user.get("UI_PWD"));
	}
	@Override
	public boolean signUp(Map<String, String> user) {
		int result = uiDAO.insertUserInfo(user);
		return result==1;
	}
	@Override
	public Map<String, String> getUser(String id) {
		return uiDAO.selectUserInfoById(id);
	}
	@Override
	public boolean update(Map<String, String> user, HttpSession session) {
		int result = uiDAO.updateUserInfo(user);
		if(result==1) {
			String id = user.get("uiId");
			Map<String,String> userInfo = uiDAO.selectUserInfoById(id);
			session.setAttribute("user", userInfo);
			return true;
		}
		return false;
	}

}